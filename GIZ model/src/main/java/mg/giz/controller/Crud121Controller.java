package mg.giz.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mg.giz.contrainte.factory.DateParserFactory;
import mg.giz.data.constants.code.TypePersonneCode;
import mg.giz.data.constants.theme.ListeSouscomposante;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.SuccessStories;
import mg.giz.data.domain.Typepersonne;
import mg.giz.data.domain.Village;
import mg.giz.repository.FormateurRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.FormateurService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud121Controller {

	@Autowired
	FormateurService formateurService;
	@Autowired
	FormateurRepository formateurRepository;
	
	@Autowired
	ThemeService themeService;
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	TypepersonneService typepersonneService;
	@Autowired
	TypepersonneRepository typepersonneRepository;
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/liste121")
	public String listSuccess(Model model) {
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		List<Formateur> formateur = formateurService.listFormateurFBS();
		model.addAttribute("formateur", formateur);
		return "crud-form/Form_list_121";
	}

	@RequestMapping("/add121")
	public String addFormateurFbsForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_121";
	}

	@RequestMapping("/save121")
	public String saveFormateurFbs(@RequestParam("formateur_nom") String formateur_nom,
			@RequestParam("formateur_genre") String formateur_genre,
			@RequestParam("formateur_date") String formateur_date,
			@RequestParam("formateur_contact") String formateur_contact, 
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("formateur_observation") String formateur_observation, 
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(formateur_date);
		Date date = Date.valueOf(dateString);
		
		Formateur formateur = new Formateur();
		int idTypepersonne = typepersonneService.findIdTypePersonne("formateurs FBS formés");
		Formateur formateurCreated = formateurService.createFormateurCrud(formateur, idTypepersonne, formateur_nom, formateur_genre, date, formateur_contact, code_fkt, formateur_observation);
		boolean duplicated = formateurService.saveCrudFormateur(formateurCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/add121";
		}
		return "redirect:/liste121";
	}

	@RequestMapping("/delete121/{id}")
	public String deleteFormateurFbs(@PathVariable(name = "id") Long id) {
		formateurRepository.deleteById(id);
		return "redirect:/liste121";
	}

	@RequestMapping("/edit121/{id}/{typepersonne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id, 
		@PathVariable(name = "typepersonne_id") int typepersonne_id,
		Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_121");
		List<Village> village = villageService.getAllVillage();
		Formateur formateur = formateurRepository.findFormateurbyId(id);
		Typepersonne typepersonne = typepersonneRepository.findTypepersonnebyId(typepersonne_id);
		
		model.addAttribute("formateur", formateur);
		mav.addObject("formateur", formateur);
		mav.addObject("typepersonne", typepersonne);
		model.addAttribute("village", village);

		return mav;
	}

	@RequestMapping(value = "/saveEdit121", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("formateur_nom") String formateur_nom,
			@RequestParam("formateur_genre") String formateur_genre,
			@RequestParam("formateur_date") Date formateur_date,
			@RequestParam("formateur_contact") String formateur_contact,
			@RequestParam("formateur_observation") String formateur_observation,
			@RequestParam("id") Long id,
			RedirectAttributes redirectAttributes)
			throws ParseException {

		Formateur formateur = formateurRepository.findFormateurbyId(id);		
		int idTypepersonne = typepersonneService.findIdTypePersonne("formateurs FBS formés");
		Formateur formateurCreated = formateurService.createFormateurCrudmodif(formateur, idTypepersonne, formateur_nom, formateur_genre, formateur_date, formateur_contact, formateur_observation);
		formateurRepository.save(formateurCreated);
		
		return "redirect:/liste121";
	}

}
