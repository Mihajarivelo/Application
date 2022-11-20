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
import mg.giz.data.domain.Nombreeleve;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.EcoleeppRepository;
import mg.giz.repository.EnseignanteppRepository;
import mg.giz.repository.HistoriqueRepository;
import mg.giz.repository.NombreeleveRepository;
import mg.giz.repository.PersonneRepository;
import mg.giz.repository.TypepersonneRepository;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.NombreeleveService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.TypepersonneService;
import mg.giz.service.metier.VillageService;

@Controller
public class Crud224Controller {

	@Autowired
	NombreeleveService nombreeleveService;
	@Autowired
	NombreeleveRepository nombreeleveRepository;
	
	@Autowired
	EcoleeppService ecoleeppService;
	@Autowired
	EcoleeppRepository ecoleeppRepository;	
	
	@Autowired
	VillageService villageService;	


	@RequestMapping("/liste224")
	public String listSuccess(Model model) {
		List<Nombreeleve> nombreeleve = nombreeleveService.listNombreeleve();
		String[][] scList = ListeSouscomposante.souscomposante();
		model.addAttribute("scList", scList);
		model.addAttribute("nombreeleve", nombreeleve);
		return "crud-form/Form_list_224";
	}
	
	@RequestMapping("/add224")
	public String addNombreeleve(Model model) {
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		return "crud-form/Form_add_224";
	}
	
	@RequestMapping("/save224")
	public String saveNombreeleve(@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("nombreeleve_garcon") Long nombreeleve_garcon,
			@RequestParam("nombreeleve_fille") Long nombreeleve_fille, 
			@RequestParam("nombreeleve_date") String nombreeleve_date,
			RedirectAttributes redirectAttributes) throws ParseException {

		String dateString = DateParserFactory.formatDate(nombreeleve_date);
		Date date = Date.valueOf(dateString);
		
		Ecoleepp ecoleepp = new Ecoleepp();
		Nombreeleve nombreeleve = new Nombreeleve();		
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		boolean duplicatedCreatedEcole = ecoleeppService.saveCrudEcoleepp(ecoleeppCreated);
		if (duplicatedCreatedEcole == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add224";
		}		

		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Nombreeleve nombreeleveCreated = nombreeleveService.createNombreeleveCrud(nombreeleve, selectEcoleepp, nombreeleve_garcon, nombreeleve_fille, date);
		boolean duplicatedCreatedEleve = nombreeleveService.saveCrudNombreeleve(nombreeleveCreated);
		if (duplicatedCreatedEleve == true) {
			redirectAttributes.addFlashAttribute("duplicatedCreated", 1);
			return "redirect:/add224";
		}
		return "redirect:/liste224";		
	}
	
	@RequestMapping("/edit224/{id}/{ecoleepp_id}")
	public ModelAndView editNombreeleve(@PathVariable(name = "id") int id,
			@PathVariable(name = "ecoleepp_id") Long ecoleepp_id,
			Model model) throws ParseException {
		
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_224");
		
		Nombreeleve nombreeleve = nombreeleveRepository.findNombreelevebyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		List<Village> village = villageService.getAllVillage();
		model.addAttribute("village", village);
		
		Date nombreeleve_date = nombreeleve.getNombreeleve_date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String strDate = inputFormat.format(nombreeleve_date);
		String dateString = DateParserFactory.formatDateInverse(strDate);		

		mav.addObject("nombreeleve", nombreeleve);		
		model.addAttribute("nombreeleve", nombreeleve);	
		mav.addObject("ecoleepp", ecoleepp);

		model.addAttribute("dateFormated", dateString);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveEdit224", method = RequestMethod.POST)
	public String EnseignantEducEnv(@RequestParam("ecoleepp_nom") String ecoleepp_nom,
			@RequestParam("code_fkt") String code_fkt,
			@RequestParam("nombreeleve_garcon") Long nombreeleve_garcon,
			@RequestParam("nombreeleve_fille") Long nombreeleve_fille, 
			@RequestParam("nombreeleve_date") Date nombreeleve_date,
			@RequestParam("id") int id,
			@RequestParam("ecoleepp_id") Long ecoleepp_id,
			RedirectAttributes redirectAttributes)
			throws ParseException {
		
		Nombreeleve nombreeleve = nombreeleveRepository.findNombreelevebyId(id);
		Ecoleepp ecoleepp = ecoleeppRepository.findEcoleeppbyId(ecoleepp_id);
		
		Ecoleepp ecoleeppCreated = ecoleeppService.createEcoleeppCrudEducEnv(ecoleepp, ecoleepp_nom, code_fkt);
		ecoleeppRepository.save(ecoleeppCreated);
		
		Long selectEcoleepp = ecoleeppService.listEcoleepp(ecoleepp_nom);
		Nombreeleve nombreeleveCreated = nombreeleveService.createNombreeleveCrud(nombreeleve, selectEcoleepp, nombreeleve_garcon, nombreeleve_fille, nombreeleve_date);
		nombreeleveRepository.save(nombreeleveCreated);
		
		return "redirect:/liste224";
	}
}
