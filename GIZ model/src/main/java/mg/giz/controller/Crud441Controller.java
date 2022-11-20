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
import mg.giz.data.constants.code.TypePersonneCode;
import mg.giz.data.constants.theme.ListeSouscomposante;
import mg.giz.data.domain.Ameliorer;
import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Suivitheme;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.AmeliorerRepository;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.SuivithemeRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.AmeliorerService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.SuivithemeService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud441Controller {

	@Autowired
	SuivithemeService suivithemeService;
	@Autowired
	SuivithemeRepository suivithemeRepository;
	
	@Autowired
	VillageService villageService;
	
	@Autowired
	ThemeService themeService;
	@Autowired
	ThemeRepository themeRepository;

	@RequestMapping("/liste441")
	public String listSuccess(Model model) {
		List<Suivitheme> suivitheme = suivithemeService.findSuivitheme();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("suivitheme", suivitheme);
		return "crud-form/Form_list_441";
	}
	
	@RequestMapping("/delete441/{id}")
	public String deleteAteliers(@PathVariable(name = "id") Long id) {
		suivithemeRepository.deleteById(id);
		return "redirect:/liste441";
	}	
	
	@RequestMapping("/add441")
	public String addAteliers(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_441";
	}
	
	@RequestMapping("/save441")
	public String saveAteliers(@RequestParam("code_fkt") String code_fkt,	
			@RequestParam("suivitheme_valeur") Double suivitheme_valeur,
			@RequestParam("suivitheme_date") String suivitheme_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(suivitheme_date);
		Date date = Date.valueOf(dateString);
		
		Suivitheme suivitheme = new Suivitheme();		
		
		Long idTheme = themeService.selectTheme441();
		Suivitheme suivithemeCreated = suivithemeService.createSuivithemeCrud(suivitheme, date, suivitheme_valeur, idTheme, code_fkt);
		boolean duplicatedCreatedSuivitheme = suivithemeService.saveCrudSuivitheme(suivithemeCreated);
		if (duplicatedCreatedSuivitheme == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add441";
		}	
		return "redirect:/liste441";		
	}
	
	@RequestMapping("/edit441/{id}/{theme_id}")
	public ModelAndView editEnseignantEducEnv(@PathVariable(name = "id") Long id,
			@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_441");
		
		Suivitheme suivitheme = suivithemeRepository.findByIdSuivitheme(id);
		Theme theme = themeRepository.findThemeId(theme_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		Date suivitheme_date = suivitheme.getSuivitheme_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(suivitheme_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("suivitheme", suivitheme);		
		model.addAttribute("suivitheme", suivitheme);	
		mav.addObject("theme", theme);

		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit441", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("id") Long id,
			@RequestParam("suivitheme_date") Date suivitheme_date, 
			@RequestParam("suivitheme_valeur") Double suivitheme_valeur,
			@RequestParam("code_fkt") String code_fkt,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Suivitheme suivitheme = suivithemeRepository.findByIdSuivitheme(id);
		
		Long idTheme = themeService.selectTheme441();
		Suivitheme suivithemeCreated = suivithemeService.createSuivithemeCrud(suivitheme, suivitheme_date, suivitheme_valeur, idTheme, code_fkt);
		suivithemeRepository.save(suivithemeCreated);
		
		return "redirect:/liste441";
	}
}
