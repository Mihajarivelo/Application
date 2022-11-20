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

import mg.giz.data.domain.Indicateur;
import mg.giz.repository.SouscomposanteRepository;
import mg.giz.service.metier.IndicateurCrudService;

@Controller
public class IndicateurCrudController {

	@Autowired
	IndicateurCrudService indicateurCrudService;

	@Autowired
	SouscomposanteRepository souscomposanteRepository;

	@RequestMapping(value = "/indicateurForm")
	public String indicateurForm(Model model) {
		model.addAttribute("indicateurForm", new Indicateur());
		model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
		model.addAttribute("souscomposantes", souscomposanteRepository.findAll());
		model.addAttribute("listindicateurTab", "active");
		return "indicateur-form/indicateur-view";
	}

	@PostMapping("/indicateurForm")
	public String createIndicateur(@Valid @ModelAttribute("indicateurForm") Indicateur indicateur, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("indicateurForm", indicateur);
			model.addAttribute("formindicateurTab", "active");
		} else {
			try {
				indicateurCrudService.createIndicateur(indicateur);
				model.addAttribute("indicateurForm", new Indicateur());
				model.addAttribute("listindicateurTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("indicateurForm", indicateur);
				model.addAttribute("formindicateurTab", "active");
				model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
				model.addAttribute("souscomposantes", souscomposanteRepository.findAll());
			}
		}

		model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
		model.addAttribute("souscomposantes", souscomposanteRepository.findAll());

		// return "indicateur-form/indicateur-view";
		return "redirect:/indicateurForm";
	}

	@RequestMapping(value = "/editIndicateur/{indicateur_id}")
	public String getEditIndicateurForm(Model model, @PathVariable(name = "indicateur_id") String indicateur_id)
			throws Exception {
		Indicateur indicateurToEdit = indicateurCrudService.getIndicateurById(indicateur_id);

		model.addAttribute("indicateurForm", indicateurToEdit);
		model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
		model.addAttribute("souscomposantes", souscomposanteRepository.findAll());
		model.addAttribute("formindicateurTab", "active");
		model.addAttribute("editMode", "true");
		return "indicateur-form/indicateur-view";
	}

	@PostMapping("/editIndicateur")
	public String postEditIndicateurForm(@Valid @ModelAttribute("indicateurForm") Indicateur indicateur,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("indicateurForm", indicateur);
			model.addAttribute("formindicateurTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				indicateurCrudService.updateIndicateur(indicateur);
				model.addAttribute("indicateurForm", new Indicateur());
				model.addAttribute("listindicateurTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("indicateurForm", indicateur);
				model.addAttribute("formindicateurTab", "active");
				model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
				model.addAttribute("souscomposantes", souscomposanteRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("indicateurList", indicateurCrudService.getAllIndicateurs());
		model.addAttribute("souscomposantes", souscomposanteRepository.findAll());
		// return "indicateur-form/indicateur-view";
		return "redirect:/indicateurForm";
	}

	@RequestMapping(value = "/indicateurForm/cancel")
	public String cancelEditIndicateur(ModelMap model) {
		return "redirect:/indicateurForm";
	}

	@RequestMapping(value = "/deleteIndicateur/{indicateur_id}")
	public String deleteIndicateur(Model model, @PathVariable(name = "indicateur_id") String indicateur_id) {
		try {
			indicateurCrudService.deleteIndicateur(indicateur_id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return indicateurForm(model);
		return "redirect:/indicateurForm";
	}

}
