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
import mg.giz.data.domain.Groupementprod;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.GroupementprodRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.GroupementprodService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud141Controller {

	@Autowired
	GroupementprodService groupementprodService;
	@Autowired
	GroupementprodRepository groupementprodRepository;
	
	@Autowired
	VillageService villageService;
	
	@RequestMapping("/liste141")
	public String listSuccess(Model model) {
		List<Groupementprod> groupementprod = groupementprodService.listGroupementprod();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("groupementprod", groupementprod);
		return "crud-form/Form_list_141";
	}	
	
	@RequestMapping("/delete141/{groupementprod_id}")
	public String deleteGroupementprod(@PathVariable(name = "groupementprod_id") Long groupementprod_id) {
		groupementprodRepository.deleteById(groupementprod_id);
		return "redirect:/liste141";
	}
	
	@RequestMapping("/add141")
	public String addGroupementprod(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_141";
	}
	
	@RequestMapping("/save141")
	public String saveGroupementprod(@RequestParam("groupementprod_nom") String groupementprod_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("groupementprod_date") String groupementprod_date,
			@RequestParam("groupementprod_service") String groupementprod_service, 
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(groupementprod_date);
		Date date = Date.valueOf(dateString);
		
		Groupementprod groupementprod = new Groupementprod();
		Groupementprod groupementCreated = groupementprodService.createGroupementprodCrud(groupementprod, groupementprod_nom, code_fkt, date, groupementprod_service);
		boolean duplicatedCreatedGrp = groupementprodService.saveGroupemenentprod(groupementCreated);
		if (duplicatedCreatedGrp == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add141";
		}
		
		return "redirect:/liste141";		
	}	
	
	@RequestMapping("/edit141/{groupementprod_id}")
	public ModelAndView editGroupementprod(@PathVariable(name = "groupementprod_id") Long groupementprod_id,
			Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_141");
		Groupementprod groupementprod = groupementprodRepository.findGroupementprodbyId(groupementprod_id); 
		List<Village> village = villageService.getAllVillage();
		mav.addObject("groupementprod", groupementprod);
		model.addAttribute("groupementprod", groupementprod);
		model.addAttribute("village", village);
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit141", method = RequestMethod.POST)
	public String Groupementprod(@RequestParam("groupementprod_id") Long groupementprod_id,
			@RequestParam("groupementprod_nom") String groupementprod_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("groupementprod_date") Date groupementprod_date,
			@RequestParam("groupementprod_service") String groupementprod_service, 			
			RedirectAttributes redirectAttributes)
			throws ParseException {
		Groupementprod groupementprod = groupementprodRepository.findGroupementprodbyId(groupementprod_id);
		
		Groupementprod groupementprodCreated = groupementprodService.createGroupementprodCrud(groupementprod, groupementprod_nom, code_fkt, groupementprod_date, groupementprod_service);
		groupementprodRepository.save(groupementprodCreated);
		
		return "redirect:/liste141";
	}	
}
