package mg.giz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.data.domain.Accueil;
import mg.giz.service.metier.AccueilService;

@Controller
public class AccueilController {

	@Autowired
	AccueilService accueilService;


	@RequestMapping(value = { "/export-list" })
	public String export() {
		return "indicateur/export-list.html";
	}

	@RequestMapping(value = "/home")
	public String accueilPage(Model model) {
		model.addAttribute("homeList", accueilService.getAllAccueils());
		return "home-page/home-view";
	}
	
	@RequestMapping(value = "/accueilForm")
	public String accueilForm(Model model) {
		model.addAttribute("accueilForm", new Accueil());
		model.addAttribute("accueilList", accueilService.getAllAccueils());
		model.addAttribute("accueilTab", "active");
		return "accueil-form/accueil-view";
	}

	@PostMapping("/accueilForm")
	public String createAccueil(@Valid @ModelAttribute("accueilForm") Accueil accueil, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("accueilForm", accueil);
			model.addAttribute("formaccueilTab", "active");
		} else {
			try {
				accueilService.createAccueil(accueil);
				model.addAttribute("accueilForm", new Accueil());
				model.addAttribute("accueilTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("accueilForm", accueil);
				model.addAttribute("formaccueilTab", "active");
				model.addAttribute("accueilList", accueilService.getAllAccueils());
			}
		}

		model.addAttribute("accueilList", accueilService.getAllAccueils());
		return "redirect:/accueilForm";
	}

	@RequestMapping(value = "/editAccueil/{id}")
	public String getEditAccueilForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Accueil accueilToEdit = accueilService.getAccueilById(id);

		model.addAttribute("accueilForm", accueilToEdit);
		model.addAttribute("accueilList", accueilService.getAllAccueils());
		model.addAttribute("formaccueilTab", "active");
		model.addAttribute("editMode", "true");

		return "accueil-form/accueil-view";
	}

	@PostMapping("/editAccueil")
	public String postEditAccueilForm(@Valid @ModelAttribute("accueilForm") Accueil accueil, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("accueilForm", accueil);
			model.addAttribute("formaccueilTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				accueilService.updateAccueil(accueil);
				model.addAttribute("accueilForm", new Accueil());
				model.addAttribute("accueilTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("accueilForm", accueil);
				model.addAttribute("formaccueilTab", "active");
				model.addAttribute("accueilList", accueilService.getAllAccueils());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("accueilList", accueilService.getAllAccueils());
		// return "accueil-form/accueil-view";
		return "redirect:/accueilForm";

	}

	@RequestMapping(value = "/accueilForm/cancel")
	public String cancelEditAccueil(ModelMap model) {
		return "redirect:/accueilForm";
	}

	@RequestMapping(value = "/deleteAccueil/{id}")
	public String deleteAccueil(Model model, @PathVariable(name = "id") Long id) {
		try {
			accueilService.deleteAccueil(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return accueilForm(model);
		return "redirect:/accueilForm";
	}

}
