package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mg.giz.data.domain.Useremail;
import mg.giz.service.metier.SendingMailService;

import javax.validation.Valid;

@Controller
public class FormController {

	@Autowired
	SendingMailService sendingMailService;

	@GetMapping("/contact")
	public String contact() {
		return "redirect:/form";
	}

	@GetMapping("/form")
	public String formGet(Model model) {
		model.addAttribute("useremail", new Useremail());
		return "form";
	}

	@PostMapping("/form")
	public String formPost(@Valid Useremail useremail, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "form";
		}

		model.addAttribute("noErrors", true);
		model.addAttribute("useremail", useremail);
		String subject = useremail.getName() + " " + useremail.getEmail() + " sent you a message";
		sendingMailService.sendMail(subject, useremail.getMessage());
		return "form";
	}

}
