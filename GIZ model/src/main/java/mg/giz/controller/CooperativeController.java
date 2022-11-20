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

import mg.giz.data.domain.Suivithemecoop;
import mg.giz.service.metier.CooperativeService;

@Controller
public class CooperativeController {

	@Autowired
	CooperativeService cooperativeService;

	@RequestMapping(value = "/suivithemecoopForm")
	public String suivithemecoopForm(Model model) {
		model.addAttribute("suivithemecoopForm", new Suivithemecoop());
		model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

		model.addAttribute("listsuivithemecoopTab", "active");
		return "cooperative-form/cooperative-view";
	}

	@PostMapping("/suivithemecoopForm")
	public String createSuivithemecoop(@Valid @ModelAttribute("suivithemecoopForm") Suivithemecoop suivithemecoop,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("suivithemecoopForm", suivithemecoop);
			model.addAttribute("formsuivithemecoopTab", "active");
		} else {
			try {
				cooperativeService.createSuivithemecoop(suivithemecoop);
				model.addAttribute("suivithemecoopForm", new Suivithemecoop());
				model.addAttribute("listsuivithemecoopTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("suivithemecoopForm", suivithemecoop);
				model.addAttribute("formsuivithemecoopTab", "active");
				model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

			}
		}

		model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

		// return "cooperative-form/cooperative-view";
		return "redirect:/suivithemecoopForm";
	}

	@RequestMapping(value = "/editSuivithemecoop/{id}")
	public String getEditsuivithemecoopForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Suivithemecoop suivithemecoopToEdit = cooperativeService.getSuivithemecoopById(id);

		model.addAttribute("suivithemecoopForm", suivithemecoopToEdit);
		model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

		model.addAttribute("formsuivithemecoopTab", "active");
		model.addAttribute("editMode", "true");
		return "cooperative-form/cooperative-view";
	}

	@PostMapping("/editSuivithemecoop")
	public String postEditsuivithemecoopForm(@Valid @ModelAttribute("suivithemecoopForm") Suivithemecoop suivithemecoop,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("suivithemecoopForm", suivithemecoop);
			model.addAttribute("formsuivithemecoopTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				cooperativeService.updateSuivithemecoop(suivithemecoop);
				model.addAttribute("suivithemecoopForm", new Suivithemecoop());
				model.addAttribute("listsuivithemecoopTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("suivithemecoopForm", suivithemecoop);
				model.addAttribute("formsuivithemecoopTab", "active");
				model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("suivithemecoopList", cooperativeService.getAllSuivithemecoops());

		// return "cooperative-form/cooperative-view";
		return "redirect:/suivithemecoopForm";

	}

	@RequestMapping(value = "/suivithemecoopForm/cancel")
	public String cancelEditSuivithemecoop(ModelMap model) {
		return "redirect:/suivithemecoopForm";
	}

	@RequestMapping(value = "/deleteSuivithemecoop/{id}")
	public String deleteSuivithemecoop(Model model, @PathVariable(name = "id") Long id) {
		try {
			cooperativeService.deleteSuivithemecoop(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return suivithemecoopForm(model);
		return "redirect:/suivithemecoopForm";
	}
}
