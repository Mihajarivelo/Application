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
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Projetmfr;
import mg.giz.data.domain.Village;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.OtivRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.ProjetmfrRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.OtivService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.ProjetmfrService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud215Controller {

	@Autowired
	OtivService otivService;	
	@Autowired
	OtivRepository otivRepository;
	
	@Autowired
	ProjetmfrService projetmfrService;	
	@Autowired
	ProjetmfrRepository projetmfrRepository;
	
	@Autowired
	PersonneService personneService;	
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/liste215")
	public String listSuccess(Model model) {
		List<Projetmfr> projetmfr = projetmfrService.listProjetmfr();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("projetmfr", projetmfr);
		return "crud-form/Form_list_215";
	}	
	
	@RequestMapping("/delete215/{id}")
	public String deleteHistoriquePersonnePepinieriste(@PathVariable(name = "id") Long id) {
		projetmfrRepository.deleteById(id);
		return "redirect:/liste215";
	}
	
	@RequestMapping("/add215")
	public String addJeuneMFR(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_215";
	}
	
	@RequestMapping("/save215")
	public String saveJeuneMFR(@RequestParam("otiv_code") String otiv_code,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("projetmfr_date") String projetmfr_date,
			@RequestParam("projetmfr_promotion") String projetmfr_promotion,
			@RequestParam("projetmfr_realisees") String projetmfr_realisees,
			@RequestParam("projetmfr_validees") String projetmfr_validees,
			@RequestParam("projetmfr_remarque") String projetmfr_remarque,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(projetmfr_date);
		Date date = Date.valueOf(dateString);
		
		Personne personne = new Personne();
		Otiv otiv = new Otiv();
		Projetmfr projetmfr = new Projetmfr();		
		
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		boolean duplicatedCreatedPers = personneService.saveCrudPersonne(personneCreated);
		if (duplicatedCreatedPers == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add215";
		}
		
		Otiv otivCreated = otivService.createOtivCrud(otiv, otiv_code);
		boolean duplicateCreatedOtiv = otivService.saveCrudOtiv(otivCreated);
		if (duplicateCreatedOtiv == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add215";
		}
		
		int idOtiv = otivService.selectOtiv(otiv_code);
		Long idPersonne = personneService.listPersonne(personne_nom);
		Projetmfr projetmfrCreated = projetmfrService.createProjetmrfCrud215(projetmfr, idPersonne, idOtiv, date, projetmfr_promotion, projetmfr_realisees, projetmfr_validees, projetmfr_remarque);
		boolean duplicatedCreatedPrj = projetmfrService.saveCrudProjetmfr(projetmfrCreated);
		if (duplicatedCreatedPrj == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add215";
		}	
		
		return "redirect:/liste215";		
	}
	
	@RequestMapping("/edit215/{id}/{personne_id}/{otiv_id}")
	public ModelAndView editHitoriquePersonnePepinieriste(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			@PathVariable(name = "otiv_id") int otiv_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_215");
		
		Projetmfr projetmfr = projetmfrRepository.findProjetmfrbyId(id);
		Otiv otiv = otivRepository.findOtivbyId(otiv_id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		
		List<Village> village = villageService.getAllVillage();
		mav.addObject("projetmfr", projetmfr);
		model.addAttribute("projetmfr", projetmfr);
		mav.addObject("personne", personne);
		mav.addObject("otiv", otiv);
		model.addAttribute("village", village);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit215", method = RequestMethod.POST)
	public String HistoriquePersonnePepinieriste(@RequestParam("otiv_code") String otiv_code,
			@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("projetmfr_date") Date projetmfr_date,
			@RequestParam("projetmfr_promotion") String projetmfr_promotion,
			@RequestParam("projetmfr_realisees") String projetmfr_realisees,
			@RequestParam("projetmfr_validees") String projetmfr_validees,
			@RequestParam("projetmfr_remarque") String projetmfr_remarque,
			@RequestParam("personne_id") Long personne_id,
			@RequestParam("otiv_id") int otiv_id,
			@RequestParam("id") Long id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Projetmfr projetmfr = projetmfrRepository.findProjetmfrbyId(id);
		Otiv otiv = otivRepository.findOtivbyId(otiv_id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		personneRepository.save(personneCreated);
		
		Otiv otivCreated = otivService.createOtivCrud(otiv, otiv_code);
		otivRepository.save(otivCreated);
		
		int idOtiv = otivService.selectOtiv(otiv_code);
		Long idPersonne = personneService.listPersonne(personne_nom);
		Projetmfr projetmfrCreated = projetmfrService.createProjetmrfCrud215(projetmfr, idPersonne, idOtiv, projetmfr_date, projetmfr_promotion, projetmfr_realisees, projetmfr_validees, projetmfr_remarque);
		projetmfrRepository.save(projetmfrCreated);
		
		return "redirect:/liste215";
	}
}
