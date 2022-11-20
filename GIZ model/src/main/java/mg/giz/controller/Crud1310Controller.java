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
import mg.giz.data.domain.Visiteurferme;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.SuivithemeRepository;
import mg.giz.repository.VisiteurfermeRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.SuivithemeService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;
import mg.giz.service.metier.VisiteurfermeService;

@Controller
public class Crud1310Controller {

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
	VisiteurfermeService visiteurfermeService;
	
	@Autowired
	VisiteurfermeRepository visiteurfermeRepository;
	
	@RequestMapping("/list_1310")
	public String liste(Model model) {
		List<Visiteurferme> visiteurferme = visiteurfermeService.listfetchdata();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("visiteurferme", visiteurferme);
		return "crud-form/Form_list_1310";
	}
	@RequestMapping("/add1310")
	public String addFormateurFbsForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_1310";
	}
	@RequestMapping("/save1310")
	public String save1310(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("visiteurferme_nom") String visiteurferme_nom,
			@RequestParam("visiteurferme_date") String stringdat,
			@RequestParam("visiteurferme_valeur") Long visiteurferme_valeur,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Visiteurferme visiteurferme = new Visiteurferme();
		String date_visit = DateParserFactory.formatDate(stringdat);
		Date visiteurferme_date = Date.valueOf(date_visit);
		
		Visiteurferme visiteurfermeCreated = visiteurfermeService.createVisiteurfermeCrud(visiteurferme, visiteurferme_nom, visiteurferme_valeur, visiteurferme_date, code_fkt);
		boolean duplicated = visiteurfermeService.saveCrudVisiteurferme(visiteurfermeCreated);
		if (duplicated == true) {
			redirectAttributes.addFlashAttribute("duplicated", 1);
			return "redirect:/add1310";
		}

		return "redirect:/list_1310";
		
	}
	
	@RequestMapping("/edit1310/{id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_1310");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		Visiteurferme vf = visiteurfermeRepository.findByIdVisiteurferme(id);
		mav.addObject("visiteurferme", vf);
		return mav;
	}
	
	@RequestMapping(value = "/saveModification1310", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("visiteurferme_nom") String visiteurferme_nom,
			@RequestParam("visiteurferme_date") Date visiteurferme_date,
			@RequestParam("visiteurferme_valeur") Long visiteurferme_valeur, @RequestParam("id") Long id,
			@RequestParam("code_fkt") String code_fkt,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Visiteurferme visiteurferme = visiteurfermeRepository.findByIdVisiteurferme(id);
		Visiteurferme visiteurfermeCreated = visiteurfermeService.createVisiteurfermeCrud(visiteurferme, visiteurferme_nom, visiteurferme_valeur, visiteurferme_date, code_fkt);
		visiteurfermeRepository.save(visiteurfermeCreated);
		
		return "redirect:/list_1310";
	}
	
	@RequestMapping("/delete1310/{id}")
	public String deleteSensibilise(@PathVariable(name = "id") Long id) {
		visiteurfermeService.deleteVisiteurferme(id);
		return "redirect:/list_1310";
	}
		
}
