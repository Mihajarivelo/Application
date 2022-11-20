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
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud127Controller {

	@Autowired
	HistoriqueService historiqueService;
	
	@Autowired
	HistoriqueRepository historiqueRepository;
	
	@Autowired
	TypepersonneService typepersonneService;
	
	@Autowired
	TypepersonneRepository typepersonneRepository;
	
	@Autowired
	PersonneService personneService;
	
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/liste127")
	public String listSuccess(Model model) {
		int typepersonne = typepersonneService.findIdTypePersonne("personnes ressources opérationnelles");
		List <Historique> historique = historiqueService.listHistorique(typepersonne);
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("historique", historique);
		return "crud-form/Form_list_127";
	}
	
	@RequestMapping("/delete127/{id}")
	public String deleteHistoriquePersonneRessource(@PathVariable(name = "id") Long id) {
		historiqueRepository.deleteById(id);
		return "redirect:/liste127";
	}
	
	@RequestMapping("/add127")
	public String addHistoriquePersonneRessource(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_127";
	}
	
	@RequestMapping("/save127")
	public String saveHistoriquePersonneRessource(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact, 
			@RequestParam("historique_date") String historique_date, 
			@RequestParam("code_fkt") String code_fkt, 
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(historique_date);
		Date date = Date.valueOf(dateString);
		
		Personne personne = new Personne();
		Historique historique = new Historique();
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		boolean duplicatedCreatedPers = personneService.saveCrudPersonne(personneCreated);
		if (duplicatedCreatedPers == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add127";
		}
		
		int typepersonne = typepersonneService.findIdTypePersonne("personnes ressources opérationnelles");
		Long id_personne = personneRepository.selectPerson(personne_nom);
		Historique historiqueCreated = historiqueService.createHistoriqueCrud(historique, id_personne, typepersonne, date);
		boolean duplicatedCreatedHisto = historiqueService.saveCrudHistorique(historiqueCreated);
		
		if (duplicatedCreatedHisto == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add127";
		}
		return "redirect:/liste127";		
	}	
	
	@RequestMapping("/edit127/{id}/{personne_id}/{typepersonne_id}")
	public ModelAndView editHitoriquePersonneRessource(@PathVariable(name = "id") Long id,
			@PathVariable(name = "personne_id") Long personne_id,
			@PathVariable(name = "typepersonne_id") int typepersonne_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_127");
		Historique historique = historiqueRepository.findHistoriquebyId(id);
		Personne personne = personneRepository.findPersonnebyId(personne_id);

		mav.addObject("historique", historique);
		model.addAttribute("historique", historique);
		mav.addObject("personne", personne);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit127", method = RequestMethod.POST)
	public String HistoriquePersonneRessource(@RequestParam("personne_nom") String personne_nom,
			@RequestParam("personne_genre") String personne_genre,
			@RequestParam("personne_anneenaiss") Long personne_anneenaiss,
			@RequestParam("personne_lieunaiss") String personne_lieunaiss, 
			@RequestParam("personne_cin") String personne_cin,
			@RequestParam("personne_adresse") String personne_adresse,
			@RequestParam("personne_contact") String personne_contact, 
			@RequestParam("historique_date") Date historique_date,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("id") Long id,
			@RequestParam("personne_id") Long personne_id,
			@RequestParam("typepersonne_id") int typepersonne_id,			
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Personne personne = personneRepository.findByIdPersonne(personne_id);
		Historique historique = historiqueRepository.findHistoriquebyId(id);
		
		Personne personneCreated = personneService.createPersonneCrudHist(personne, personne_nom, personne_genre, personne_anneenaiss, personne_lieunaiss, personne_cin, personne_adresse, code_fkt, personne_contact);
		personneRepository.save(personneCreated);
		Historique historiqueCreated = historiqueService.createHistoriqueCrud(historique, personne_id, typepersonne_id, historique_date);
		historiqueRepository.save(historiqueCreated);
		
		return "redirect:/liste127";
	}	
}
