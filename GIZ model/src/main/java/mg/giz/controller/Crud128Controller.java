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
public class Crud128Controller {

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

	@RequestMapping("/list_128")
	public String liste(Model model) {
		Long id = themeService.selectThm("1.2.8");
		List<Beneficierpgm> Beneficierpgm = beneficierPgmService.ListRenforcement(id);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_128";
	}

	@RequestMapping("/add128")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_128";
	}

	@RequestMapping("/save128")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom, @RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") String dateString,
			@RequestParam("beneficierpgm_speculation") String beneficierpgm_speculation,
			@RequestParam("beneficierpgm_lieu") String beneficierpgm_lieu,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss, RedirectAttributes redirectAttributes)
			throws ParseException {

		Long theme_id = themeService.selectThm("1.2.8");
		Personne personne = new Personne();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		String date_benef = DateParserFactory.formatDate(dateString);
		Date beneficierpgm_date = Date.valueOf(date_benef);
		Personne personneCreated = personneService.createPersonnCrud128(personne, personne_nom, personne_genre,
				personne_anneenaiss, code_fkt);
		boolean duplicated = personneService.saveCrudPersonne(personneCreated);

		Long selectpersonne = personneService.findPersonneCrud(personne_nom, personne_genre, code_fkt);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.create128Crud(beneficierpgm, beneficierpgm_lieu,
				beneficierpgm_speculation, beneficierpgm_date, selectpersonne, theme_id);
		boolean duplicatedCreated = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreated == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add128";
		}
		return "redirect:/list_128";
	}

	@RequestMapping("/delete128/{id}")
	public String delete125(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/list_128";
	}

	@RequestMapping("/edit128/{id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_128");
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

	@RequestMapping(value = "/saveModification128", method = RequestMethod.POST)
	public String saveModification125(@RequestParam("code_fkt") String code_fkt, @RequestParam("id") Long id,
			@RequestParam("personne_nom") String personne_nom, @RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_id") Long personne_id, @RequestParam("beneficierpgm_date") Date beneficierpgm_date,
			@RequestParam("beneficierpgm_speculation") String beneficierpgm_speculation,
			@RequestParam("beneficierpgm_lieu") String beneficierpgm_lieu,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss, RedirectAttributes redirectAttributes)
			throws ParseException {
		Long theme_id = themeService.selectThm("1.2.8");
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findByIdPersonne(personne_id);

		Beneficierpgm beneficierpgmCreated = beneficierPgmService.create128Crud(beneficierpgm, beneficierpgm_lieu,
				beneficierpgm_speculation, beneficierpgm_date, personne_id, theme_id);
		Long isDuplicated = beneficierpgmRepository.VerifyDuplicatedCrud(personne_id, theme_id, beneficierpgm_date);

		if (isDuplicated == null || isDuplicated.equals(id)) {
			beneficierpgmRepository.save(beneficierpgmCreated);
			Personne personnerCreated = personneService.createPersonnCrud128(personne, personne_nom, personne_genre,
					personne_anneenaiss, code_fkt);
			personneRepository.save(personnerCreated);
		} else {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			String url = "redirect:/edit128/" + id + "/" + personne_id;
			return url;
		}

		return "redirect:/list_128";

	}

}
