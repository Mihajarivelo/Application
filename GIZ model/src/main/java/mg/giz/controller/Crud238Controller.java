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
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.AmeliorerRepository;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.AmeliorerService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud238Controller {

	@Autowired
	AmeliorerService ameliorerService;
	@Autowired
	AmeliorerRepository ameliorerRepository;
	
	@Autowired
	VillageService villageService;
	
	@Autowired
	ThemeService themeService;
	@Autowired
	ThemeRepository themeRepository;

	@RequestMapping("/liste238")
	public String listSuccess(Model model) {
		List<Ameliorer> ameliorer = ameliorerService.findAmeliorer();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("ameliorer", ameliorer);
		return "crud-form/Form_list_238";
	}
	
	@RequestMapping("/delete238/{id}")
	public String deleteVillageEauPotable(@PathVariable(name = "id") Long id) {
		ameliorerRepository.deleteById(id);
		return "redirect:/liste238";
	}	
	
	@RequestMapping("/add238")
	public String addVillageEauPotable(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_238";
	}
	
	@RequestMapping("/save238")
	public String saveVillageEauPotable(@RequestParam("code_fkt") String code_fkt,	
			@RequestParam("eaupotable_date") String eaupotable_date,
			@RequestParam("eaupotable_observation") String eaupotable_observation,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(eaupotable_date);
		Date date = Date.valueOf(dateString);
		
		Ameliorer ameliorer = new Ameliorer();			
		
		Long idTheme = themeService.selectTheme238();
		Ameliorer ameliorerCreated = ameliorerService.createAmeliorer238(ameliorer, code_fkt, date, eaupotable_observation, idTheme);
		boolean duplicatedCreatedAmeliorer = ameliorerService.saveCrudAmeliorer(ameliorerCreated);
		if (duplicatedCreatedAmeliorer == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add238";
		}		
		return "redirect:/liste238";		
	}
	
	@RequestMapping("/edit238/{id}/{theme_id}")
	public ModelAndView editEnseignantEducEnv(@PathVariable(name = "id") Long id,
			@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_238");
		
		Ameliorer ameliorer = ameliorerRepository.findAmeliorerbyId(id);
		Theme theme = themeRepository.findThemeId(theme_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		Date eaupotable_date = ameliorer.getEaupotable_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(eaupotable_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("ameliorer", ameliorer);		
		model.addAttribute("ameliorer", ameliorer);	
		mav.addObject("theme", theme);

		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit238", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("id") Long id,
			@RequestParam("eaupotable_date") Date eaupotable_date, 
			@RequestParam("eaupotable_observation") String eaupotable_observation,
			@RequestParam("code_fkt") String code_fkt,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Ameliorer ameliorer = ameliorerRepository.findAmeliorerbyId(id);
		
		Long idTheme = themeService.selectTheme238();
		Ameliorer ameliorerCreated = ameliorerService.createAmeliorer238(ameliorer, code_fkt, eaupotable_date, eaupotable_observation, idTheme);
		ameliorerRepository.save(ameliorerCreated);
		
		return "redirect:/liste238";
	}
}
