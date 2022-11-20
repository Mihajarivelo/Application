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

import mg.giz.data.domain.Commentaire;
import mg.giz.repository.IndicateurRepository;
import mg.giz.service.metier.CommentaireService;

@Controller
public class CommentaireController {

	@Autowired
	CommentaireService commentaireService;

	@Autowired
	IndicateurRepository indicateurRepository;

	@RequestMapping(value = "/commentaireForm")
	public String commentaireForm(Model model) {
		model.addAttribute("commentaireForm", new Commentaire());
		model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		model.addAttribute("listcommentaireTab", "active");
		return "commentaire-form/commentaire-view";
	}

	@PostMapping("/commentaireForm")
	public String createCommentaire(@Valid @ModelAttribute("commentaireForm") Commentaire commentaire,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("commentaireForm", commentaire);
			model.addAttribute("formcommentaireTab", "active");
		} else {
			try {
				commentaireService.createCommentaire(commentaire);
				model.addAttribute("commentaireForm", new Commentaire());
				model.addAttribute("listcommentaireTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("commentaireForm", commentaire);
				model.addAttribute("formcommentaireTab", "active");
				model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
				model.addAttribute("indicateurs", indicateurRepository.findAll());
				
			}
		}

		model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		
		// return "commentaire-form/commentaire-view";
		return "redirect:/commentaireForm";
	}

	@RequestMapping(value = "/editCommentaire/{id}")
	public String getEditCommentaireForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Commentaire commentaireToEdit = commentaireService.getCommentaireById(id);
		model.addAttribute("commentaireForm", commentaireToEdit);
		model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		model.addAttribute("formcommentaireTab", "active");
		model.addAttribute("editMode", "true");
		return "commentaire-form/commentaire-view";
	}

	@PostMapping("/editCommentaire")
	public String postEditCommentaireForm(
			@Valid @ModelAttribute("commentaireForm") Commentaire commentaire, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("commentaireForm", commentaire);
			model.addAttribute("formcommentaireTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				commentaireService.updateCommentaire(commentaire);
				model.addAttribute("commentaireForm", new Commentaire());
				model.addAttribute("listcommentaireTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("commentaireForm", commentaire);
				model.addAttribute("formcommentaireTab", "active");
				model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
				model.addAttribute("indicateurs", indicateurRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("commentaireList", commentaireService.getAllCommentaires());
		model.addAttribute("indicateurs", indicateurRepository.findAll());
		// return "commentaire-form/commentaire-view";
		return "redirect:/commentaireForm";

	}

	@RequestMapping(value = "/commentaireForm/cancel")
	public String cancelEditCommentaire(ModelMap model) {
		return "redirect:/commentaireForm";
	}

	@RequestMapping(value = "/deleteCommentaire/{id}")
	public String deleteCommentaire(Model model, @PathVariable(name = "id") Long id) {
		try {
			commentaireService.deleteCommentaire(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		// return commentaireForm(model);
		return "redirect:/commentaireForm";
	}
}
