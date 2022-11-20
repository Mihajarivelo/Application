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
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud124Controller {

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
	
	@RequestMapping("/formes")
	public String liste(Model model) {
		Long id = themeService.selectId();
		List <Beneficierpgm> Beneficierpgm = beneficierPgmService.ListFormes(id);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("Beneficierpgm", Beneficierpgm);
		return "crud-form/Form_list_124";
	}
	
	@RequestMapping("/deleteFormes/{id}")
	public String deleteFormes(@PathVariable(name = "id") Long id) {
		beneficierPgmService.deleteBeneficier(id);
		return "redirect:/formes";
	}
	
	@RequestMapping("/editFormes/{id}/{personne_id}")
	public ModelAndView editFormateurFbs(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_124");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> beneficierpgm = villageService.getAllVillage();
		Beneficierpgm fr = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		mav.addObject("beneficierpgm", fr);
		model.addAttribute("beneficierpgm", beneficierpgm);
		mav.addObject("personne", personne);
		return mav;
	}
	
	@RequestMapping("/addFormesForm")
	public String addFormesForm(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_124";
	}
}
