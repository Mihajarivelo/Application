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
import mg.giz.data.domain.Fermepilote;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.FermepiloteRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.FermePiloteService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud139Controller {

	@Autowired
	HistoriqueService historiqueService;
	
	@Autowired
	HistoriqueRepository historiqueRepository;
	
	@Autowired
	TypepersonneService typepersonneService;
	
	@Autowired
	FermepiloteRepository fermepiloteRepository;
	
	@Autowired
	FermePiloteService fermePiloteService;
	
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	PersonneService personneService;
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/list_139")
	public String listSuccess(Model model) {
		List <Fermepilote> fermepilote = fermePiloteService.listFermepilote();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("fermepilote", fermepilote);
		return "crud-form/Form_list_139";
	}	
	
	@RequestMapping("/add139")
	public String addHistoriquePersonnePepinieriste(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_139";
	}
	
	@RequestMapping("/save139")
	public String saveHistoriquePersonnePepinieriste(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("fermepilote_date") String fermepilote_date,
			@RequestParam("fermepilote_lib") String fermepilote_lib,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(fermepilote_date);
		Date date = Date.valueOf(dateString);
		
		Personne personne = new Personne();
		Fermepilote fermepilote = new Fermepilote();
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		personneService.saveCrudPersonne(personneCreated);
		Long personne_id = personneRepository.selectPerson(personne_nom);
		Fermepilote fermepiloteCreated = fermePiloteService.createFermepiloteCrud(fermepilote, personne_id, fermepilote_lib, date);
		boolean duplicatedCreatedfermepilote = fermePiloteService.saveCrudFermepilote(fermepiloteCreated);
		if (duplicatedCreatedfermepilote == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add139";
		}
		return "redirect:/list_139";		
	}
	
	@RequestMapping("/edit139/{id}/{personne_id}")
	public ModelAndView edit(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_139");
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Village> fermepilote = villageService.getAllVillage();
		Fermepilote fr = fermepiloteRepository.findByIdFermepilote(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);
		mav.addObject("fermepilote", fr);
		model.addAttribute("fermepilote", fermepilote);
		mav.addObject("personne", personne);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit139", method = RequestMethod.POST)
	public String HistoriqueAsaForme(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("fermepilote_date") Date fermepilote_date,
			@RequestParam("fermepilote_lib") String fermepilote_lib,
			@RequestParam("id") Long id,
			@RequestParam("personne_id") Long personne_id,			
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Personne personne = personneRepository.findByIdPersonne(personne_id);
		Fermepilote fermepilote = fermepiloteRepository.findByIdFermepilote(id);
		
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		personneRepository.save(personneCreated);
		
		Fermepilote fermepiloteCreated = fermePiloteService.createFermepiloteCrud(fermepilote, personne_id, fermepilote_lib, fermepilote_date);
		fermepiloteRepository.save(fermepiloteCreated);
		
		return "redirect:/list_139";
	}
}
