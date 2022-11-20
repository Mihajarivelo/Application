package mg.giz.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud126bController {

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
	
	@RequestMapping("/list_126b")
	public String liste(Model model) {
		Long id = themeService.selectThm("1.2.6b");
		List <Beneficierpgm> Beneficierpgm = beneficierPgmService.ListRenforcement(id);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_126b";
	}
	@RequestMapping("/add126b")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_126b";
	}
	@RequestMapping("/save126b")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") String dateString,
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Long theme_id = themeService.selectThm("1.2.6b");
		Personne personne = new Personne();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		String date_benef = DateParserFactory.formatDate(dateString);
		Date beneficierpgm_date = Date.valueOf(date_benef);
		Personne personneCreated = personneService.createPersonCrud125(personne, personne_nom, personne_genre, personne_lieunaiss, personne_anneenaiss, personne_cin, personne_adresse, personne_contact, code_fkt);	
		boolean duplicated = personneService.saveCrudPersonne(personneCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/add126b";
		}
		Long selectpersonne = personneService.listPersonne(personne_nom);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.create125Crud(beneficierpgm, beneficierpgm_date, selectpersonne, theme_id);
		boolean duplicatedCreated = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreated == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add126b";
		}
		return "redirect:/list_126b";	
	}
	
	@RequestMapping("/delete126b/{id}")
	public String delete125(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/list_126b";
	}
	@RequestMapping("/edit126b/{id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_126b");
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
	@RequestMapping(value = "/saveModification126b", method = RequestMethod.POST)
	public String saveModification125(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("id") Long id,
			@RequestParam("personne_id") Long personne_id, 
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") Date beneficierpgm_date,
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Long theme_id = themeService.selectThm("1.2.6b");
	
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findByIdPersonne(personne_id);
		
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.create125Crud(beneficierpgm, beneficierpgm_date, personne_id, theme_id);
		beneficierpgmRepository.save(beneficierpgmCreated);
		
		Personne personnerCreated = personneService.createPersonCrud125(personne, personne_nom, personne_genre, personne_lieunaiss, personne_anneenaiss, personne_cin, personne_adresse, personne_contact, code_fkt);
		personneRepository.save(personnerCreated);
		
		return "redirect:/list_126b";
	}
	

}
