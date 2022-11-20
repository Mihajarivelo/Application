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
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud211Controller {

	@Autowired
	ThemeService themeService;	
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	VillageService villageService;
	

	@RequestMapping("/liste211")
	public String liste(Model model) {
		List<Theme> theme = themeService.themeMFR();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("theme", theme);
		return "crud-form/Form_list_211";
	}
	
	@RequestMapping("/delete211/{theme_id}")
	public String deleteHistoriquePersonneRessource(@PathVariable(name = "theme_id") Long theme_id) {
		themeRepository.deleteById(theme_id);
		return "redirect:/liste211";
	}
	
	@RequestMapping("/add211")
	public String addMfrOperationnel(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_211";
	}
	
	@RequestMapping("/save211")
	public String saveMfrOperationnel(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("theme_date") String theme_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(theme_date);
		Date date = Date.valueOf(dateString);
		
		Theme theme = new Theme();
		String programme = "MFR";
		Theme themeCreated = themeService.createThemeCrud211(theme, code_fkt, date, programme);
		boolean duplicatedCreatedTheme = themeService.saveCrudTheme(themeCreated);
		if (duplicatedCreatedTheme == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add211";
		}
		return "redirect:/liste211";		
	}
	
	@RequestMapping("/edit211/{theme_id}")
	public ModelAndView editHitoriquePersonneRessource(@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_211");

		Theme theme = themeRepository.findThemeId(theme_id);		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		mav.addObject("theme", theme);
		model.addAttribute("theme", theme);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit211", method = RequestMethod.POST)
	public String HistoriquePersonneRessource(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("theme_date") Date theme_date,
			@RequestParam("theme_id") Long theme_id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Theme theme = themeRepository.findThemeId(theme_id);		
		String programme = "MFR";
		Theme themeCreated = themeService.createThemeCrud211(theme, code_fkt, theme_date, programme);
		themeRepository.save(themeCreated);
		
		return "redirect:/liste211";
	}	
}
