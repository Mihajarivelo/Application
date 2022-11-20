package mg.giz.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mg.giz.contrainte.factory.DateParserFactory;
import mg.giz.data.constants.theme.ListeSouscomposante;
import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud115Controller {

	@Autowired
	ThemeService themeService;

	@Autowired
	VillageService villageService;

	@Autowired
	PersonneService personneService;

	@Autowired
	BeneficierPgmService beneficierPgmService;

	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;

	@Autowired
	PersonneRepository personneRepository;

	@RequestMapping("/list_115")
	public String liste(Model model) {
		Long id = themeService.selectThm("1.1.5");
		List<Beneficierpgm> Beneficierpgm = beneficierPgmService.ListRenforcement(id);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_115";
	}

	@RequestMapping("/add115")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_115";
	}

	@RequestMapping("/save115")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom, @RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") String dateString,
			@RequestParam("beneficierpgm_valeur") Long beneficierpgm_valeur,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss,
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact, RedirectAttributes redirectAttributes)
			throws ParseException {

		Long theme_id = themeService.selectThm("1.1.5");
		Personne personne = new Personne();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		String date_benef = DateParserFactory.formatDate(dateString);
		Date beneficierpgm_date = Date.valueOf(date_benef);
		Personne personneCreated = personneService.createPersonCrudM12(personne, personne_nom, personne_genre,
				personne_lieunaiss, personne_anneenaiss, personne_cin, personne_adresse, personne_contact, null,
				code_fkt);
		personneService.saveCrudPersonne(personneCreated);
		personneService.deletePersonneDuplicated();

		Long selectpersonne = personneService.findPersonneCrud(personne_nom, personne_genre, code_fkt);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBeneficierpgm3210Crud(beneficierpgm,
				beneficierpgm_valeur, beneficierpgm_date, selectpersonne, theme_id);
		boolean duplicatedCreated = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreated == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add115";
		}
		return "redirect:/list_115";
	}

	@RequestMapping("/delete115/{id}")
	public String delete125(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/list_115";
	}

	@RequestMapping("/edit115/{id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_115");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> beneficierpgm = villageService.getAllVillage();
		Beneficierpgm fr = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		mav.addObject("beneficierpgm", fr);
		model.addAttribute("beneficierpgm", beneficierpgm);
		mav.addObject("personne", personne);
		return mav;
	}

	@RequestMapping(value = "/saveModification115", method = RequestMethod.POST)
	public String saveModification125(@RequestParam("code_fkt") String code_fkt, @RequestParam("id") Long id,
			@RequestParam("personne_nom") String personne_nom, @RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_id") Long personne_id, @RequestParam("beneficierpgm_date") Date beneficierpgm_date,
			@RequestParam("beneficierpgm_valeur") Long beneficierpgm_valeur,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss,
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact, RedirectAttributes redirectAttributes)
			throws ParseException {
		Long theme_id = themeService.selectThm("1.1.5");
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findByIdPersonne(personne_id);

		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBeneficierpgm3210Crud(beneficierpgm,
				beneficierpgm_valeur, beneficierpgm_date, personne_id, theme_id);
		Long isDuplicatedBeneficiar = beneficierpgmRepository.VerifyDuplicatedCrud(personne_id, theme_id,
				beneficierpgm_date);
		Long isDuplicatedPerson = personneService.findPersonneCrud(personne_nom, personne_genre, code_fkt);

		if (isDuplicatedPerson != null && !isDuplicatedPerson.equals(personne_id)) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			String url = "redirect:/edit115/" + id + "/" + personne_id;
			return url;
		}

		if (isDuplicatedBeneficiar != null && !isDuplicatedBeneficiar.equals(id)) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			String url = "redirect:/edit115/" + id + "/" + personne_id;
			return url;

		} else {
			beneficierpgmRepository.save(beneficierpgmCreated);
			Personne personnerCreated = personneService.createPersonCrudM12(personne, personne_nom, personne_genre,
					personne_lieunaiss, personne_anneenaiss, personne_cin, personne_adresse, personne_contact, null,
					code_fkt);
			personneRepository.save(personnerCreated);
		}

		return "redirect:/list_115";
	}

}
