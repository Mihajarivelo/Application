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
public class Crud122Controller {

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
	
	@RequestMapping("/sensibilise")
	public String liste(Model model) {
		List <Beneficierpgm> Beneficierpgm = beneficierPgmService.ListSensibilite(themeService.selectId());
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_122";
	}
		
	@RequestMapping("/editSensibilise/{id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_122");
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
	
	@RequestMapping("/addSensibiliseForm")
	public String addFormateurFbsForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_122";
	}
	
	@RequestMapping("/deleteSensibilise/{id}")
	public String deleteSensibilise(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/sensibilise";
	}
	
	@RequestMapping("/saveSensibilise")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("beneficierpgm_groupemod") Integer beneficierpgm_groupemod,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_valeur") Long beneficierpgm_valeur, 
			@RequestParam("beneficierpgm_date") String dateString,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Long theme_id = themeService.selectId();
		Personne personne = new Personne();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		String date_benef = DateParserFactory.formatDate(dateString);
		Date beneficierpgm_date = Date.valueOf(date_benef);
		
		Personne personneCreated = personneService.createPersonnerCrud(personne, personne_nom, personne_genre, code_fkt,personne_anneenaiss);		
		boolean duplicated = personneService.saveCrudPersonne(personneCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/addSensibiliseForm";
		}
		Long selectpersonne = personneService.listPersonne(personne_nom);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBeneficierpgmCrud(beneficierpgm, beneficierpgm_groupemod,
				beneficierpgm_valeur, beneficierpgm_date,selectpersonne, theme_id);
		boolean duplicatedCreated = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreated == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/addSensibiliseForm";
		}
		if(beneficierpgm_groupemod == 11) {
			return "redirect:/formes";
		}	
		return "redirect:/sensibilise";
		
	}
	
	@RequestMapping(value = "/saveModificationSensibilise", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("beneficierpgm_groupemod") Integer beneficierpgm_groupemod,
			@RequestParam("beneficierpgm_valeur") Long beneficierpgm_valeur, @RequestParam("id") Long id,
			@RequestParam("beneficierpgm_date") Date beneficierpgm_date,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_id") Long personne_id, 
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Long theme_id = themeService.selectId();
		
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findByIdPersonne(personne_id);
		
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBeneficierpgmCrud(beneficierpgm, 
				beneficierpgm_groupemod, beneficierpgm_valeur, beneficierpgm_date, personne_id, theme_id);
		beneficierpgmRepository.save(beneficierpgmCreated);
		
		Personne personnerCreated = personneService.createPersonnerCrud(personne, personne_nom, personne_genre, code_fkt, personne_anneenaiss);
		personneRepository.save(personnerCreated);
		
		int i = beneficierPgmService.modifyCrudBeneficierpgm(beneficierpgmCreated, beneficierpgm_groupemod, beneficierpgm_valeur, beneficierpgm_date, personne_id, theme_id);
		int j = personneService.modifyCrudPersonne(personne_nom, personne_genre, code_fkt, personne_anneenaiss);
		
		if(beneficierpgm_groupemod == 11) {
			return "redirect:/formes";
		}	
		return "redirect:/sensibilise";
	}
}
