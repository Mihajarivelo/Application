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
import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Concerner;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Kitmadere;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.ConcernerRepository;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.KitmadereRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.ConcernerService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.KitmadereService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud1410Controller {

	@Autowired
	BeneficierPgmService beneficierPgmService;
	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;
	
	@Autowired
	PersonneService personneService;
	@Autowired
	PersonneRepository personneRepository;	
	
	@Autowired
	ThemeService themeService;
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	VillageService villageService;
	
	@RequestMapping("/liste1410")
	public String liste(Model model) {
		Long idTheme = themeService.selectThm("1.4.10");
		List <Beneficierpgm> beneficierpgm = beneficierPgmService.ListRenforcement(idTheme);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("beneficierpgm", beneficierpgm);
		return "crud-form/Form_list_1410";
	}
	
	@RequestMapping("/delete1410/{id}")
	public String deleteLeaderGrpProd(@PathVariable(name = "id") Long id) {
		beneficierpgmRepository.deleteById(id);
		return "redirect:/liste1410";
	}

	@RequestMapping("/add1410")
	public String addLeaderGrpProd(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_1410";
	}
	
	@RequestMapping("/save1410")
	public String saveLeaderGrpProd(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre, 
			@RequestParam("beneficierpgm_date") String beneficierpgm_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(beneficierpgm_date);
		Date date = Date.valueOf(dateString);
		
		Personne personne = new Personne();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		Personne personneCreated = personneService.createPersonneCrud144(personne, personne_nom, personne_genre, personne_anneenaiss, code_fkt);
		boolean duplicatedCreatedPers = personneService.saveCrudPersonne(personneCreated);
		if (duplicatedCreatedPers == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add1410";
		}
		
		Long idTheme = themeService.selectThm("1.4.10");
		Long selectPersonne = personneService.listPersonne(personne_nom);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBenefigierpgm1410Crud(beneficierpgm, selectPersonne, idTheme, date);
		boolean duplicatedCreatedBenef = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreatedBenef == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add1410";
		}
		
		return "redirect:/liste1410";	
	}
	
	@RequestMapping("/edit1410/{id}/{personne_id}/{theme_id}")
	public ModelAndView editLeaderGrpProd(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_1410");
		
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Theme theme = themeRepository.findThemeId(theme_id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		mav.addObject("beneficierpgm", beneficierpgm);
		model.addAttribute("beneficierpgm", beneficierpgm);
		mav.addObject("personne", personne);
		mav.addObject("theme", theme);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit1410", method = RequestMethod.POST)
	public String LeaderGrpProd(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre, 
			@RequestParam("beneficierpgm_date") Date beneficierpgm_date,
			@RequestParam("id") Long id,
			@RequestParam("personne_id") Long personne_id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		
		Personne personneCreated = personneService.createPersonneCrud144(personne, personne_nom, personne_genre, personne_anneenaiss, code_fkt);
		personneRepository.save(personneCreated);
		
		Long idTheme = themeService.selectThm("1.4.10");
		Long selectPersonne = personneService.listPersonne(personne_nom);
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBenefigierpgm1410Crud(beneficierpgm, selectPersonne, idTheme, beneficierpgm_date);
		beneficierpgmRepository.save(beneficierpgmCreated);
		
		return "redirect:/liste1410";
	}	
	
	
}
