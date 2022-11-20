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
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud317Controller {

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
	
	@Autowired
	ThemeRepository themeRepository;
	
	@RequestMapping("/list_317")
	public String liste(Model model) {
		List <Beneficierpgm> Beneficierpgm = beneficierPgmService.List311("VSLA fonctionnels");
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_317";
	}
	@RequestMapping("/add317")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_317";
	}
	@RequestMapping("/save317")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("theme_date") String dateString,
			@RequestParam("theme_lib") String theme_lib,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		Personne personne = new Personne();
		String dat_thm = DateParserFactory.formatDate(dateString);
		Date theme_date = Date.valueOf(dat_thm);
		
		Personne personneCreated = personneService.createPersonnCrud128(personne, personne_nom, personne_genre, personne_anneenaiss, code_fkt);
		personneService.saveCrudPersonne(personneCreated);
		
		String theme_programme = "VSLA fonctionnels";
		String souscomposante_code = "SC3.1";
		Theme theme = new Theme();
		Theme themeCreated = themeService.createThemeCrud(theme, theme_lib, souscomposante_code, theme_programme, theme_date, code_fkt);
		themeService.saveCrudTheme(themeCreated);
		
		Long personne_id = personneService.listPersonne(personne_nom);
		Long theme_id = themeService.listTheme(theme_lib, theme_programme);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.create311Crud(beneficierpgm, personne_id, theme_id);
		boolean duplicatedBen = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedBen == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add317";
		}
		return "redirect:/list_317";	
	}
	
	@RequestMapping("/delete317/{id}")
	public String deleteSensibilise(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/list_317";
	}
	
	@RequestMapping("/edit317/{theme_id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "theme_id") Long theme_id,
			@PathVariable(name = "personne_id") Long personne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_317");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> beneficierpgm = villageService.getAllVillage();
		Theme th = themeRepository.findThemeId(theme_id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		mav.addObject("theme", th);
		model.addAttribute("beneficierpgm", beneficierpgm);
		mav.addObject("personne", personne);
		return mav;
	}
	
	@RequestMapping(value = "/saveModification317", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("theme_date") Date theme_date,
			@RequestParam("theme_lib") String theme_lib,
			@RequestParam("theme_id") Long theme_id,
			@RequestParam("personne_id") Long personne_id,
			RedirectAttributes redirectAttributes)
			throws ParseException {		
		String theme_programme = "VSLA fonctionnels";
		String souscomposante_code = "SC3.1";
		Theme thm = themeRepository.findThemeId(theme_id);
		Personne pers = personneRepository.findByIdPersonne(personne_id);
		
		Theme themeCreated = themeService.createThemeCrud(thm, theme_lib, souscomposante_code, theme_programme, theme_date, code_fkt);
		themeRepository.save(themeCreated);
		
		Personne personnerCreated = personneService.createPersonnerCrud(pers, personne_nom, personne_genre, code_fkt, personne_anneenaiss);
		personneRepository.save(personnerCreated);
		
		return "redirect:/list_317";
	}
	
}
