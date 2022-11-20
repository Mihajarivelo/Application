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

import mg.giz.data.domain.Glossaire;
import mg.giz.service.metier.GlossaireService;

@Controller
public class GlossaireController {

	@Autowired
	GlossaireService glossaireService;
	
	@RequestMapping(value = "/glossaireForm")
	public String glossaireForm(Model model) {
		model.addAttribute("glossaireForm", new Glossaire());
		model.addAttribute("glossaireList", glossaireService.getAllGlossaires());
		model.addAttribute("glossaireTab", "active");
		return "glossaire-form/glossaire-view";
	}

	@PostMapping("/glossaireForm")
	public String createGlossaire(@Valid @ModelAttribute("glossaireForm") Glossaire glossaire,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("glossaireForm", glossaire);
			model.addAttribute("formglossaireTab", "active");
		} else {
			try {
				glossaireService.createGlossaire(glossaire);
				model.addAttribute("glossaireForm", new Glossaire());
				model.addAttribute("glossaireTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("glossaireForm", glossaire);
				model.addAttribute("formglossaireTab", "active");
				model.addAttribute("glossaireList", glossaireService.getAllGlossaires());

			}
		}

		model.addAttribute("glossaireList", glossaireService.getAllGlossaires());
		return "redirect:/glossaireForm";
	}

	@RequestMapping(value = "/editGlossaire/{id}")
	public String getEditGlossaireForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Glossaire glossaireToEdit = glossaireService.getGlossaireById(id);
		model.addAttribute("glossaireForm", glossaireToEdit);
		model.addAttribute("glossaireList", glossaireService.getAllGlossaires());
		model.addAttribute("formglossaireTab", "active");
		model.addAttribute("editMode", "true");
		return "glossaire-form/glossaire-view";
	}

	@PostMapping("/editGlossaire")
	public String postEditGlossaireForm(
			@Valid @ModelAttribute("glossaireForm") Glossaire glossaire, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("glossaireForm", glossaire);
			model.addAttribute("formglossaireTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				glossaireService.updateGlossaire(glossaire);
				model.addAttribute("glossaireForm", new Glossaire());
				model.addAttribute("glossaireTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("glossaireForm", glossaire);
				model.addAttribute("formglossaireTab", "active");
				model.addAttribute("glossaireList", glossaireService.getAllGlossaires());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("glossaireList", glossaireService.getAllGlossaires());
		return "glossaire-form/glossaire-view";

	}

	@RequestMapping(value = "/glossaireForm/cancel")
	public String cancelEditGlossaire(ModelMap model) {
		return "redirect:/glossaireForm";
	}

	@RequestMapping(value = "/deleteGlossaire/{id}")
	public String deleteGlossaire(Model model, @PathVariable(name = "id") Long id) {
		try {
			glossaireService.deleteGlossaire(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		return "redirect:/glossaireForm";
	}

}
