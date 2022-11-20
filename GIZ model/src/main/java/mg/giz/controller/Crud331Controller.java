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
import mg.giz.data.domain.Menagessensibilise;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.MenagessensibiliseRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.MenagessensibiliseService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud331Controller {

	@Autowired
	ThemeService themeService;
	
	@Autowired
	VillageService villageService;
	
	@Autowired
	PersonneService personneService;
	
	@Autowired
	MenagessensibiliseService menagessensibiliseService;
	
	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;
	
	@Autowired
	MenagessensibiliseRepository menagessensibiliseRepository;
	
	@RequestMapping("/list_331")
	public String liste(Model model) {
		List <Menagessensibilise>  menagessensibilises = menagessensibiliseService.List331();
		System.out.print(menagessensibilises);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("menagessensibilises", menagessensibilises);
		return "crud-form/Form_list_331";
	}
	@RequestMapping("/add331")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_331";
	}
	@RequestMapping("/save331")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("menagessensibilise_date") String dateString,
			@RequestParam("menagessensibilise_lib") String menagessensibilise_lib,
			@RequestParam("menagessensibilise_homme") int menagessensibilise_homme,
			@RequestParam("menagessensibilise_femme") int menagessensibilise_femme,
			@RequestParam("menagessensibilise_garcon") int menagessensibilise_garcon,
			@RequestParam("menagessensibilise_fille") int menagessensibilise_fille,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Menagessensibilise menagessensibilise = new Menagessensibilise();
		String date_menag = DateParserFactory.formatDate(dateString);
		Date menagessensibilise_date = Date.valueOf(date_menag);
		Menagessensibilise menagessensibiliseCreated = menagessensibiliseService.createPersonCrud331(menagessensibilise, code_fkt, menagessensibilise_date, menagessensibilise_lib, menagessensibilise_homme, menagessensibilise_femme, menagessensibilise_garcon, menagessensibilise_fille);
		boolean duplicated = menagessensibiliseService.saveCrudMenagessensibilise(menagessensibiliseCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/add331";
		}
		return "redirect:/list_331";	
	}
	@RequestMapping("/edit331/{id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") int id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_331");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> menagessensibilise = villageService.getAllVillage();
		Menagessensibilise fr = menagessensibiliseRepository.findByIdMenagessensibilise(id);
		mav.addObject("menagessensibilise", fr);
		model.addAttribute("menagessensibilise", menagessensibilise);
		return mav;
	}
	
	@RequestMapping(value = "/saveModification331", method = RequestMethod.POST)
	public String saveModification125(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("id") int id,			
			@RequestParam("menagessensibilise_date") Date menagessensibilise_date,
			@RequestParam("menagessensibilise_lib") String menagessensibilise_lib,
			@RequestParam("menagessensibilise_homme") int menagessensibilise_homme,
			@RequestParam("menagessensibilise_femme") int menagessensibilise_femme,
			@RequestParam("menagessensibilise_garcon") int menagessensibilise_garcon,
			@RequestParam("menagessensibilise_fille") int menagessensibilise_fille,
			RedirectAttributes redirectAttributes)
			throws ParseException {		
		Menagessensibilise menagessensibilises = menagessensibiliseRepository.findByIdMenagessensibilise(id);
	
		Menagessensibilise menagessensibilisespgmCreated = menagessensibiliseService.createPersonCrud331(menagessensibilises, code_fkt, menagessensibilise_date, menagessensibilise_lib, menagessensibilise_homme, menagessensibilise_femme, menagessensibilise_garcon, menagessensibilise_fille);
		menagessensibiliseRepository.save(menagessensibilisespgmCreated);
	
		return "redirect:/list_331";
	}
	

	@RequestMapping("/delete331/{id}")
	public String delete331(@PathVariable(name = "id") int id) {
		menagessensibiliseRepository.deleteMenagessensibiliseQuery(id);
		return "redirect:/list_331";
	}
	
}
