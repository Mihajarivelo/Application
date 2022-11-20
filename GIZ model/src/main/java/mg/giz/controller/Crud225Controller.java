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
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud225Controller {

	@Autowired
	EnseignanteppService enseignanteppService;
	@Autowired
	EnseignanteppRepository enseignanteppRepository;
	
	@Autowired
	EcoleeppService ecoleeppService;
	@Autowired
	EcoleeppRepository ecoleeppRepository;	
	
	@Autowired
	VillageService villageService;

	@RequestMapping("/liste225")
	public String listSuccess(Model model) {
		List <Enseignantepp> enseignantepp = enseignanteppService.findEnseignantepp();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("enseignantepp", enseignantepp);
		return "crud-form/Form_list_225";
	}
	
	@RequestMapping("/delete225/{id}")
	public String deleteEnseignantEducEnv(@PathVariable(name = "id") Long id) {
		enseignanteppRepository.deleteById(id);
		return "redirect:/liste225";
	}	

	@RequestMapping("/add225")
	public String addEnseignantEducEnv(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_225";
	}
	
	@RequestMapping("/save225")
	public String saveEnseignantEducEnv(@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("enseignantepp_nom") String enseignantepp_nom,
			@RequestParam("enseignantepp_genre") String enseignantepp_genre, 
			@RequestParam("enseignantepp_fonction") String enseignantepp_fonction,
			@RequestParam("enseignantepp_classe") String enseignantepp_classe,
			@RequestParam("enseignantepp_date") String enseignantepp_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(enseignantepp_date);
		Date date = Date.valueOf(dateString);
		
		Ecoleepp ecoleepp = new Ecoleepp();
		Enseignantepp enseignantepp = new Enseignantepp();		
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		boolean duplicatedCreatedEcole = ecoleeppService.saveCrudEcoleepp(ecoleeppCreated);
		if (duplicatedCreatedEcole == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add225";
		}		

		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Enseignantepp enseignanteppCreated = enseignanteppService.createEnseignanteppCrudEducEnv(enseignantepp, selectEcoleepp, enseignantepp_nom, enseignantepp_genre, enseignantepp_fonction, enseignantepp_classe, date);
		boolean duplicatedCreatedEns = enseignanteppService.saveCrudEnseignantepp(enseignanteppCreated);
		if (duplicatedCreatedEns == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add225";
		}
		
		return "redirect:/liste225";		
	}
	
	@RequestMapping("/edit225/{id}/{ecoleepp_id}")
	public ModelAndView editEnseignantEducEnv(@PathVariable(name = "id") Long id,
			@PathVariable(name = "ecoleepp_id") Long ecoleepp_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_225");
		
		Enseignantepp enseignantepp = enseignanteppRepository.findEnseignanteppbyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		Date enseignantepp_date = enseignantepp.getEnseignantepp_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(enseignantepp_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("enseignantepp", enseignantepp);		
		model.addAttribute("enseignantepp", enseignantepp);	
		mav.addObject("ecoleepp", ecoleepp);

		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit225", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("ecoleepp_id") Long ecoleepp_id,
			@RequestParam("enseignantepp_nom") String enseignantepp_nom,
			@RequestParam("enseignantepp_genre") String enseignantepp_genre, 
			@RequestParam("enseignantepp_fonction") String enseignantepp_fonction,
			@RequestParam("enseignantepp_classe") String enseignantepp_classe,
			@RequestParam("enseignantepp_date") Date enseignantepp_date,
			@RequestParam("id") Long id,
			@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Enseignantepp enseignantepp = enseignanteppRepository.findEnseignanteppbyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		ecoleeppRepository.save(ecoleeppCreated);
		
		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Enseignantepp enseignanteppCreated = enseignanteppService.createEnseignanteppCrudEducEnv(enseignantepp, selectEcoleepp, enseignantepp_nom, enseignantepp_genre, enseignantepp_fonction, enseignantepp_classe, enseignantepp_date);
		enseignanteppRepository.save(enseignanteppCreated);
		
		return "redirect:/liste225";
	}
}
