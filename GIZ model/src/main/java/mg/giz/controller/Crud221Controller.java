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
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Subvenirepp;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.SubvenireppRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.SubvenireppService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud221Controller {

	@Autowired
	ThemeService themeService;
	
	@Autowired
	VillageService villageService;
	
	@Autowired
	EcoleeppService ecoleeppService;
	
	@Autowired
	SubvenireppService subvenireppService;
	
	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;
	
	@Autowired
	EcoleeppRepository ecoleeppRepository;
	
	@Autowired
	SubvenireppRepository subvenireppRepository;
	
	@RequestMapping("/list_221")
	public String liste(Model model) {
		List <Subvenirepp> subvenirepp = subvenireppService.List221();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("subvenirepp", subvenirepp);
		return "crud-form/Form_list_221";
	}
	
	@RequestMapping("/add221")
	public String addFormateurFbsForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_221";
	}
	
	@RequestMapping("/save221")
	public String saveSensibilise(@RequestParam("code_fkt") String code_fkt,
			@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("subvenirepp_rehabilitaion") Double subvenirepp_rehabilitaion,
			@RequestParam("subvenirepp_salaire") Double subvenirepp_salaire,
			@RequestParam("subvenirepp_fourniture") Double subvenirepp_fourniture,
			@RequestParam("subvenirepp_ansco") String subvenirepp_ansco, 
			@RequestParam("subvenirepp_date") String dateString,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		String dateStri = DateParserFactory.formatDate(dateString);
		Date date = Date.valueOf(dateStri);
		
		Ecoleepp ecoleepp = new Ecoleepp();	
		Subvenirepp subvenirepp = new Subvenirepp();
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		ecoleeppService.saveCrudEcoleepp(ecoleeppCreated);
		
		
		Long ecoleepp_id = ecoleeppService.findEcoleepp(ecoleepp_nom, code_fkt);
		Subvenirepp subvenireppCreated = subvenireppService.createSubvenireppCrud(subvenirepp, subvenirepp_rehabilitaion, subvenirepp_salaire, subvenirepp_fourniture, subvenirepp_ansco, date, ecoleepp_id);
		boolean duplicatedCreated = subvenireppService.saveCrudSubvenirepp(subvenireppCreated);
		if (duplicatedCreated == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/addSensibiliseForm";
		}
		return "redirect:/list_221";
		
	}
	
	@RequestMapping("/edit221/{id}/{ecoleepp_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "ecoleepp_id") Long ecoleepp_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_221");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> ecoleepp = villageService.getAllVillage();
		Ecoleepp fr = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		Subvenirepp subvenirepp = subvenireppRepository.findByIdSubvenirepp(id);
		mav.addObject("ecoleepp", fr);
		model.addAttribute("subvenirepp", ecoleepp);
		mav.addObject("subvenirepp", subvenirepp);
		return mav;
	}
	
	@RequestMapping(value = "/saveModification221", method = RequestMethod.POST)
	public String saveFormateur(@RequestParam("ecoleepp_id") Long ecoleepp_id,
			@RequestParam("id") Long id,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("subvenirepp_rehabilitaion") Double subvenirepp_rehabilitaion,
			@RequestParam("subvenirepp_salaire") Double subvenirepp_salaire,
			@RequestParam("subvenirepp_fourniture") Double subvenirepp_fourniture,
			@RequestParam("subvenirepp_ansco") String subvenirepp_ansco, 
			@RequestParam("subvenirepp_date") Date subvenirepp_date,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		Subvenirepp subvenirepp = subvenireppRepository.findByIdSubvenirepp(id);
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		ecoleeppRepository.save(ecoleeppCreated);
		
		Subvenirepp subvenireppCreated = subvenireppService.createSubvenireppCrud(subvenirepp, subvenirepp_rehabilitaion, subvenirepp_salaire, subvenirepp_fourniture, subvenirepp_ansco, subvenirepp_date, ecoleepp_id);
		subvenireppRepository.save(subvenireppCreated);
		
		return "redirect:/list_221";
	}
	
	@RequestMapping("/delete221/{id}")
	public String deleteSensibilise(@PathVariable(name = "id") Long id) {
		subvenireppService.deleteSubvenirepp(id);
		return "redirect:/list_221";
	}
}
