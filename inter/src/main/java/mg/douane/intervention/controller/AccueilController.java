package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.Role;
import mg.douane.intervention.repository.AgentRepository;
import mg.douane.intervention.repository.RoleRepository;
import mg.douane.intervention.service.AgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.*;

@Controller
public class AccueilController {
    @Autowired
    AgentServiceImpl agentService;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/home")
    public String accueilPage(Model model) {
        return "home";
    }

    @RequestMapping(value = "/agent")
    public String gereAgentPage(Model model) {
        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("roleList", roleRepository.findAll());
        return "Admin/GererAgent";
    }

    @PostMapping("/addRole")
    public String createRole(@Valid @ModelAttribute("roleFrm") Role role, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("roleFrm", role);
        } else {
            try {

            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
            }
        }

        return "redirect:/agent";
    }
}
