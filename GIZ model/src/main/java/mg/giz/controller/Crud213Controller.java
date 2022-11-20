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
import mg.giz.data.domain.Otiv;
import mg.giz.data.domain.Parentmfr;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Projetmfr;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.BeneficierpgmRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.OtivRepository;
import mg.giz.repository.ParentmfrRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.ProjetmfrRepository;
import mg.giz.repository.ThemeRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.OtivService;
import mg.giz.service.metier.ParentmfrService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ProjetmfrService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud213Controller {

	@Autowired
	ThemeService themeService;
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	BeneficierPgmService beneficierPgmService;
	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;
	
	@Autowired
	ParentmfrService parentmfrService;
	@Autowired
	ParentmfrRepository parentmfrRepository;
	
	@Autowired
	PersonneService personneService;	
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	VillageService villageService;
	

	@RequestMapping("/liste213")
	public String listSuccess(Model model) {
		List<Beneficierpgm> beneficierpgm = beneficierPgmService.listBenef213();
		System.out.println(beneficierpgm);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("beneficierpgm", beneficierpgm);
		return "crud-form/Form_list_213";
	}	
	
	@RequestMapping("/delete213/{id}")
	public String deleteHistoriquePersonnePepinieriste(@PathVariable(name = "id") Long id) {
		beneficierpgmRepository.deleteById(id);
		return "redirect:/liste213";
	}
	
	@RequestMapping("/add213")
	public String addJeuneMFR(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_213";
	}
	
	@RequestMapping("/save213")
	public String saveJeuneMFR(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") String beneficierpgm_date, 
			@RequestParam("inscrismfr_niveau") String inscrismfr_niveau,
			@RequestParam("inscrismfr_anneesco") String inscrismfr_anneesco,
			@RequestParam("parentmfr_nom") String parentmfr_nom,
			@RequestParam("parentmfr_fonction") String parentmfr_fonction,
			@RequestParam("personne_adresse") String personne_adresse,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(beneficierpgm_date);
		Date date = Date.valueOf(dateString);
		
		Personne personne = new Personne();
		Parentmfr parentmfr = new Parentmfr();
		Beneficierpgm beneficierpgm = new Beneficierpgm();
		
		Parentmfr parentmfrCreated = parentmfrService.createParentmfrCrud213(parentmfr, parentmfr_nom, parentmfr_fonction);
		boolean duplicatedCreatedParent = parentmfrService.saveCrudParentmfr(parentmfrCreated);
		if (duplicatedCreatedParent == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add213";
		}
		
		Long idParent = parentmfrService.findParentmfr(parentmfr_nom);
		Personne personneCreated = personneService.createPersonneCrud213(personne, idParent, personne_nom, code_fkt, personne_anneenaiss, personne_genre, personne_adresse);
		boolean duplicatedCreatedPers = personneService.saveCrudPersonne(personneCreated);
		if (duplicatedCreatedPers == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add213";
		}
		
		Long idPersonne = personneService.listPersonne(personne_nom);
		Long idTheme = themeService.selectTheme213();
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBenefCrud213(beneficierpgm, idPersonne, idTheme, inscrismfr_niveau, inscrismfr_anneesco, date);
		boolean duplicatedCreatedBenef = beneficierPgmService.saveCrudBeneficierpgm(beneficierpgmCreated);
		if (duplicatedCreatedBenef == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add213";
		}
		
		return "redirect:/liste213";		
	}	
	
	@RequestMapping("/edit213/{id}/{personne_id}/{theme_id}")
	public ModelAndView editHitoriquePersonnePepinieriste(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			@PathVariable(name = "theme_id") Long theme_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_213");
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		Theme theme = themeRepository.findThemeId(theme_id);
		
		List<Village> village = villageService.getAllVillage();
		mav.addObject("beneficierpgm", beneficierpgm);
		model.addAttribute("beneficierpgm", beneficierpgm);
		mav.addObject("personne", personne);
		mav.addObject("theme", theme);
		model.addAttribute("village", village);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit213", method = RequestMethod.POST)
	public String HistoriquePersonnePepinieriste(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("beneficierpgm_date") Date beneficierpgm_date, 
			@RequestParam("inscrismfr_niveau") String inscrismfr_niveau,
			@RequestParam("inscrismfr_anneesco") String inscrismfr_anneesco,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_id") Long personne_id,
			@RequestParam("id") Long id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Personne personne = personneRepository.findByIdPersonne(personne_id);
		Beneficierpgm beneficierpgm = beneficierpgmRepository.findByIdBeneficierpgm(id);
		
		Personne personneCreated = personneService.createPersonneCrud213M(personne, personne_nom, code_fkt, personne_anneenaiss, personne_genre, personne_adresse);
		personneRepository.save(personneCreated);
		
		Long idPersonne = personneService.listPersonne(personne_nom);
		Long idTheme = themeService.selectTheme213();
		Beneficierpgm beneficierpgmCreated = beneficierPgmService.createBenefCrud213(beneficierpgm, idPersonne, idTheme, inscrismfr_niveau, inscrismfr_anneesco, beneficierpgm_date);
		beneficierpgmRepository.save(beneficierpgmCreated);
		
		return "redirect:/liste213";
	}	
}
