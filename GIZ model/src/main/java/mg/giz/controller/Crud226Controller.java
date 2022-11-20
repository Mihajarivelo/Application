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
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Kitmadere;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.KitmadereRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.KitmadereService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud226Controller {

	@Autowired
	EnseignanteppService enseignanteppService;
	@Autowired
	EnseignanteppRepository enseignanteppRepository;
	
	@Autowired
	KitmadereService kitmadereService;
	@Autowired
	KitmadereRepository kitmadereRepository;
	
	@Autowired
	EcoleeppService ecoleeppService;
	@Autowired
	EcoleeppRepository ecoleeppRepository;	
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/liste226")
	public String listSuccess(Model model) {
		List<Kitmadere> kitmadere = kitmadereService.joinKitEnsEcole();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("kitmadere", kitmadere);
		return "crud-form/Form_list_226";
	}
	
	@RequestMapping("/delete226/{id}")
	public String deleteEnseignantKitmadere(@PathVariable(name = "id") Long id) {
		kitmadereRepository.deleteById(id);
		return "redirect:/liste226";
	}
	
	@RequestMapping("/add226")
	public String addEnseignantKitmadere(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_226";
	}
	
	@RequestMapping("/save226")
	public String saveEnseignantKitmadere(@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("enseignantepp_nom") String enseignantepp_nom,
			@RequestParam("enseignantepp_genre") String enseignantepp_genre, 
			@RequestParam("enseignantepp_fonction") String enseignantepp_fonction,
			@RequestParam("enseignantepp_classe") String enseignantepp_classe,			
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("kitmadere_date") String kitmadere_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(kitmadere_date);
		Date date = Date.valueOf(dateString);
		
		Ecoleepp ecoleepp = new Ecoleepp();
		Enseignantepp enseignantepp = new Enseignantepp();
		Kitmadere kitmadere = new Kitmadere();
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		boolean duplicatedCreatedEcole = ecoleeppService.saveCrudEcoleepp(ecoleeppCreated);
		if (duplicatedCreatedEcole == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add226";
		}		
		
		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Enseignantepp enseignanteppCreated = enseignanteppService.createEnseignanteppCrudKitemadere(enseignantepp, selectEcoleepp, enseignantepp_nom, enseignantepp_genre, enseignantepp_fonction, enseignantepp_classe);
		boolean duplicatedCreatedEns = enseignanteppService.saveCrudEnseignantepp(enseignanteppCreated);
		if (duplicatedCreatedEns == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add226";
		}
		
		Long selectEnseignantepp = enseignanteppService.listEnseignantepp(enseignantepp_nom);
		Kitmadere kitmadereCreated = kitmadereService.createKitmadereCrud(kitmadere, selectEnseignantepp, date);
		boolean duplicatedCreatedKit = kitmadereService.saveCrudKitmadere(kitmadereCreated);
		if (duplicatedCreatedKit == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add226";
		}
		
		return "redirect:/liste226";		
	}
	
	@RequestMapping("/edit226/{id}/{enseignantepp_id}")
	public ModelAndView editEnseignantKitmadere(@PathVariable(name = "id") Long id,
			@PathVariable(name = "enseignantepp_id") Long enseignantepp_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_226");
		
		Enseignantepp enseignantepp = enseignanteppRepository.findEnseignanteppbyId(enseignantepp_id);
		Kitmadere kitmadere = kitmadereRepository.findKitmaderebyId(id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		List<Ecoleepp> ecoleepp = ecoleeppService.getAllEcoleepp();
		model.addAttribute("ecoleepp", ecoleepp);
		
		Date kitmadere_date = kitmadere.getKitmadere_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(kitmadere_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("enseignantepp", enseignantepp);		
		model.addAttribute("enseignantepp", enseignantepp);
		mav.addObject("kitmadere", kitmadere);		
		model.addAttribute("kitmadere", kitmadere);
		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit226", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("ecoleepp_id") Long ecoleepp_id,
			@RequestParam("enseignantepp_nom") String enseignantepp_nom,
			@RequestParam("enseignantepp_genre") String enseignantepp_genre, 
			@RequestParam("enseignantepp_fonction") String enseignantepp_fonction,
			@RequestParam("enseignantepp_classe") String enseignantepp_classe,
			@RequestParam("kitmadere_date") Date kitmadere_date,
			@RequestParam("id") Long id,
			@RequestParam("enseignantepp_id") Long enseignantepp_id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Enseignantepp enseignantepp = enseignanteppRepository.findEnseignanteppbyId(enseignantepp_id);
		Kitmadere kitmadere = kitmadereRepository.findKitmaderebyId(id);		

		Enseignantepp enseignanteppCreated = enseignanteppService.createEnseignanteppCrudKitemadere(enseignantepp, ecoleepp_id, enseignantepp_nom, enseignantepp_genre, enseignantepp_fonction, enseignantepp_classe);
		enseignanteppRepository.save(enseignanteppCreated);
		
		Long selectEnseignantepp = enseignanteppService.listEnseignantepp(enseignantepp_nom);
		Kitmadere kitmadereCreated = kitmadereService.createKitmadereCrud(kitmadere, selectEnseignantepp, kitmadere_date);
		kitmadereRepository.save(kitmadereCreated);
		
		return "redirect:/liste226";
	}
}
