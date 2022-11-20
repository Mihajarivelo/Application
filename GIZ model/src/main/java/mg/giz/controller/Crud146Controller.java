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
import mg.giz.data.domain.Suivitheme;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.SuivithemeRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.SuivithemeService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud146Controller {

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
	SuivithemeService suivithemeService;
	
	@Autowired
	SuivithemeRepository suivithemeRepository;
	
	@RequestMapping("/list_146")
	public String liste(Model model) {
		Long theme_id = themeService.selectThm("1.4.6");
		List<Suivitheme> suivitheme = suivithemeService.listfetchdata(theme_id);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("suivitheme", suivitheme);
		return "crud-form/Form_list_146";
	}
	@RequestMapping("/add146")
	public String addFormateurFbsForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_146";
	}
	@RequestMapping("/save146")
	public String save146(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("suivitheme_date") String dateString,
			@RequestParam("suivitheme_homme") int suivitheme_homme,
			@RequestParam("suivitheme_femme") int suivitheme_femme,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Long theme_id = themeService.selectThm("1.4.6");
		Suivitheme suivitheme = new Suivitheme();
		String date_suivithm = DateParserFactory.formatDate(dateString);
		Date suivitheme_date = Date.valueOf(date_suivithm);
		
		Suivitheme suivithemeCreated = suivithemeService.create146eCrud(suivitheme, suivitheme_date, suivitheme_homme, suivitheme_femme, theme_id, code_fkt);
		boolean duplicated = suivithemeService.saveCrudSuivitheme(suivithemeCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/add146";
		}

		return "redirect:/list_146";
		
	}
	
	@RequestMapping("/edit146/{id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_146");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		Suivitheme st = suivithemeRepository.findByIdSuivitheme(id);
		mav.addObject("suivitheme", st);
		return mav;
	}
	
	@RequestMapping(value = "/saveModification146", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("suivitheme_date") Date suivitheme_date,
			@RequestParam("suivitheme_homme") int suivitheme_homme,
			@RequestParam("suivitheme_femme") int suivitheme_femme, @RequestParam("id") Long id,
			@RequestParam("code_fkt") String code_fkt,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Long theme_id = themeService.selectThm("1.4.6");
		Suivitheme suivitheme = suivithemeRepository.findByIdSuivitheme(id);
		Suivitheme suivithemeCreated = suivithemeService.create146eCrud(suivitheme, suivitheme_date, suivitheme_homme, suivitheme_femme, theme_id, code_fkt);
		suivithemeRepository.save(suivithemeCreated);
		
		return "redirect:/list_146";
	}
	
	@RequestMapping("/delete146/{id}")
	public String deleteSensibilise(@PathVariable(name = "id") Long id) {
		suivithemeRepository.deleteById(id);
		return "redirect:/list_146";
	}
		
}
