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

import mg.giz.data.domain.Rapportperiodique;
import mg.giz.repository.IndicateurRepository;
import mg.giz.service.metier.RapportperiodiqueService;

@Controller
public class RapportperiodiqueController {

	@Autowired
	RapportperiodiqueService rapportperiodiqueService;

	@Autowired
	IndicateurRepository indicateurRepository;

	@RequestMapping(value = "/rapportForm")
	public String rapportForm(Model model) {
		model.addAttribute("rapportForm", new Rapportperiodique());
		model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		model.addAttribute("listrapportTab", "active");
		return "rapport-form/rapport-view";
	}

	@PostMapping("/rapportForm")
	public String createRapportperiodique(@Valid @ModelAttribute("rapportForm") Rapportperiodique rapportperiodique,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("rapportForm", rapportperiodique);
			model.addAttribute("formrapportTab", "active");
		} else {
			try {
				rapportperiodiqueService.createRapportperiodique(rapportperiodique);
				model.addAttribute("rapportForm", new Rapportperiodique());
				model.addAttribute("listrapportTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("rapportForm", rapportperiodique);
				model.addAttribute("formrapportTab", "active");
				model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
				model.addAttribute("indicateurs", indicateurRepository.findAll());

			}
		}

		model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
		model.addAttribute("indicateurs", indicateurRepository.findAll());

		// return "rapport-form/rapport-view";
		return "redirect:/rapportForm";
	}

	@RequestMapping(value = "/editRapportperiodique/{id}")
	public String getEditRapportperiodiqueForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Rapportperiodique rapportperiodiqueToEdit = rapportperiodiqueService.getRapportperiodiqueById(id);

		model.addAttribute("rapportForm", rapportperiodiqueToEdit);
		model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		model.addAttribute("formrapportTab", "active");
		model.addAttribute("editMode", "true");
		return "rapport-form/rapport-view";
	}

	@PostMapping("/editRapportperiodique")
	public String postEditRapportperiodiqueForm(
			@Valid @ModelAttribute("rapportForm") Rapportperiodique rapportperiodique, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("rapportForm", rapportperiodique);
			model.addAttribute("formrapportTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				rapportperiodiqueService.updateRapportperiodique(rapportperiodique);
				model.addAttribute("rapportForm", new Rapportperiodique());
				model.addAttribute("listrapportTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("rapportForm", rapportperiodique);
				model.addAttribute("formrapportTab", "active");
				model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
				model.addAttribute("indicateurs", indicateurRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("rapportList", rapportperiodiqueService.getAllRapportperiodiques());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		// return "rapport-form/rapport-view";
		return "redirect:/rapportForm";

	}

	@RequestMapping(value = "/rapportForm/cancel")
	public String cancelEditRapportperiodique(ModelMap model) {
		return "redirect:/rapportForm";
	}

	@RequestMapping(value = "/deleteRapportperiodique/{id}")
	public String deleteRapportperiodique(Model model, @PathVariable(name = "id") Long id) {
		try {
			rapportperiodiqueService.deleteRapportperiodique(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return rapportForm(model);
		return "redirect:/rapportForm";
	}
}
