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

import mg.giz.data.domain.Capitalisation;
import mg.giz.service.metier.CapitalisationService;

@Controller
public class CapitalisationController {

	@Autowired
	CapitalisationService capitalisationService;
	
	@RequestMapping(value = "/capitalisationForm")
	public String capitalisationForm(Model model) {
		model.addAttribute("capitalisationForm", new Capitalisation());
		model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());	
		model.addAttribute("capitalisationTab", "active");
		return "capitalisation-form/capitalisation-view";
	}

	@PostMapping("/capitalisationForm")
	public String createCapitalisation(@Valid @ModelAttribute("capitalisationForm") Capitalisation capitalisation,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("capitalisationForm", capitalisation);
			model.addAttribute("formcapitalisationTab", "active");
		} else {
			try {
				capitalisationService.createCapitalisation(capitalisation);
				model.addAttribute("capitalisationForm", new Capitalisation());
				model.addAttribute("capitalisationTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("capitalisationForm", capitalisation);
				model.addAttribute("formcapitalisationTab", "active");
				model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());	
			}
		}

		model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());
		// return "capitalisation-form/capitalisation-view";
		return "redirect:/capitalisationForm";
	}

	@RequestMapping(value = "/editCapitalisation/{id}")
	public String getEditCapitalisationForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Capitalisation capitalisationToEdit = capitalisationService.getCapitalisationById(id);

		model.addAttribute("capitalisationForm", capitalisationToEdit);
		model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());
		model.addAttribute("formcapitalisationTab", "active");
		model.addAttribute("editMode", "true");
		return "capitalisation-form/capitalisation-view";
	}

	@PostMapping("/editCapitalisation")
	public String postEditCapitalisationForm(
			@Valid @ModelAttribute("capitalisationForm") Capitalisation capitalisation, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("capitalisationForm", capitalisation);
			model.addAttribute("formcapitalisationTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				capitalisationService.updateCapitalisation(capitalisation);
				model.addAttribute("capitalisationForm", new Capitalisation());
				model.addAttribute("capitalisationTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("capitalisationForm", capitalisation);
				model.addAttribute("formcapitalisationTab", "active");
				model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("capitalisationList", capitalisationService.getAllCapitalisations());
		// return "capitalisation-form/capitalisation-view";
		return "redirect:/capitalisationForm";

	}

	@RequestMapping(value = "/capitalisationForm/cancel")
	public String cancelEditCapitalisation(ModelMap model) {
		return "redirect:/capitalisationForm";
	}

	@RequestMapping(value = "/deleteCapitalisation/{id}")
	public String deleteCapitalisation(Model model, @PathVariable(name = "id") Long id) {
		try {
			capitalisationService.deleteCapitalisation(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return capitalisationForm(model);
		return "redirect:/capitalisationForm";
	}
}
