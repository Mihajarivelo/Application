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
import mg.giz.data.domain.Village;
import mg.giz.repository.ConcernerRepository;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.KitmadereRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.ConcernerService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.KitmadereService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud227Controller {

	@Autowired
	ConcernerService concernerService;
	@Autowired
	ConcernerRepository concernerRepository;	
	
	@Autowired
	EcoleeppService ecoleeppService;
	@Autowired
	EcoleeppRepository ecoleeppRepository;	
	
	@Autowired
	VillageService villageService;
	
	@RequestMapping("/liste227")
	public String listSuccess(Model model) {
		List <Concerner> concerner = concernerService.joinConcernerEcoleepp();		
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("concerner", concerner);
		return "crud-form/Form_list_227";
	}
	
	@RequestMapping("/delete227/{id}")
	public String deleteEnseignantEducEnv(@PathVariable(name = "id") Long id) {
		concernerRepository.deleteById(id);
		return "redirect:/liste227";
	}	

	@RequestMapping("/add227")
	public String addEcoleEducEnv(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_227";
	}
	
	@RequestMapping("/save227")
	public String saveEcoleEducEnv(@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("concerner_typeecole") String concerner_typeecole,
			@RequestParam("concerner_date") String concerner_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(concerner_date);
		Date date = Date.valueOf(dateString);
		
		Ecoleepp ecoleepp = new Ecoleepp();
		Concerner concerner = new Concerner();
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		boolean duplicatedCreatedEcole = ecoleeppService.saveCrudEcoleepp(ecoleeppCreated);
		if (duplicatedCreatedEcole == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add227";
		}
		
		Long selectEcole = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Concerner concernerCreated = concernerService.createConcernerCrudEducEnv(concerner, selectEcole, concerner_typeecole, date);
		boolean duplicatedCreatedConcerner = concernerService.saveCrudConcerner(concernerCreated);
		if (duplicatedCreatedConcerner == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add227";
		}
		return "redirect:/liste227";		
	}
	
	@RequestMapping("/edit227/{id}/{ecoleepp_id}")
	public ModelAndView editEnseignantEducEnv(@PathVariable(name = "id") Long id,
			@PathVariable(name = "ecoleepp_id") Long ecoleepp_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_227");
		
		Concerner concerner = concernerRepository.findConcernerbyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		Date concerner_date = concerner.getConcerner_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(concerner_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("concerner", concerner);		
		model.addAttribute("concerner", concerner);	
		mav.addObject("ecoleepp", ecoleepp);

		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit227", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("ecoleepp_id") Long ecoleepp_id,
			@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt, 
			@RequestParam("concerner_date") Date concerner_date,
			@RequestParam("concerner_typeecole") String concerner_typeecole,
			@RequestParam("id") Long id,
			RedirectAttributes redirectAttributes)
			throws ParseException {		

		Concerner concerner = concernerRepository.findConcernerbyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		ecoleeppRepository.save(ecoleeppCreated);
		
		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Concerner concernerCreated = concernerService.createConcernerCrudEducEnv(concerner, selectEcoleepp, concerner_typeecole, concerner_date);
		concernerRepository.save(concernerCreated);
		
		return "redirect:/liste227";
	}
}
