package mg.giz.controller;

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
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Suivitheme;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.SuivithemeRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.SuivithemeService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud135Controller {

	@Autowired
	ThemeService themeService;	
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	SuivithemeService suivithemeService;	
	@Autowired
	SuivithemeRepository suivithemeRepository;
	
	@Autowired
	VillageService villageService;
	
	@RequestMapping("/liste135")
	public String listSuccess(Model model) {
		List<Suivitheme> suivitheme = suivithemeService.findSuivitheme135();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("suivitheme", suivitheme);
		return "crud-form/Form_list_135";
	}
	

	@RequestMapping("/delete135/{id}")
	public String deleteCheptel(@PathVariable(name = "id") Long id) {
		suivithemeRepository.deleteById(id);
		return "redirect:/liste135";
	}
	
	@RequestMapping("/add135")
	public String addCheptel(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_135";
	}
	
	@RequestMapping("/save135")
	public String saveCheptel(@RequestParam("suivitheme_valeur") Double suivitheme_valeur,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("suivitheme_date") String suivitheme_date,		
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(suivitheme_date);
		Date date = Date.valueOf(dateString);

		Suivitheme suivitheme = new Suivitheme();
		
		Long idTheme = themeService.selectTheme135();
		Suivitheme suivithemeCreated = suivithemeService.createCrud135(suivitheme, idTheme, suivitheme_valeur, code_fkt, date);
		boolean duplicatedCreatedSuivi = suivithemeService.saveCrudSuivitheme(suivithemeCreated);
		if (duplicatedCreatedSuivi == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add135";
		}		
		return "redirect:/liste135";		
	}
	
	@RequestMapping("/edit135/{id}/{theme_id}")
	public ModelAndView editCheptel(@PathVariable(name = "id") Long id,
			@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_135");
		Suivitheme suivitheme = suivithemeRepository.findByIdSuivitheme(id);
		Theme theme = themeRepository.findThemeId(theme_id);
		
		List<Village> village = villageService.getAllVillage();
		mav.addObject("suivitheme", suivitheme);
		model.addAttribute("suivitheme", suivitheme);
		mav.addObject("theme", theme);
		model.addAttribute("village", village);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit135", method = RequestMethod.POST)
	public String Cheptel(@RequestParam("suivitheme_valeur") Double suivitheme_valeur,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("suivitheme_date") Date suivitheme_date,
			@RequestParam("id") Long id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Suivitheme suivitheme = suivithemeRepository.findByIdSuivitheme(id);

		Long idTheme = themeService.selectTheme135();
		Suivitheme suivithemeCreated = suivithemeService.createCrud135(suivitheme, idTheme, suivitheme_valeur, code_fkt, suivitheme_date);
		suivithemeRepository.save(suivithemeCreated);
		
		return "redirect:/liste135";
	}	
}
