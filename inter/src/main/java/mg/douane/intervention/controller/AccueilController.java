package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.Categorie;
import mg.douane.intervention.data.domaine.Role;
import mg.douane.intervention.repository.AgentRepository;
import mg.douane.intervention.repository.CategorieRepository;
import mg.douane.intervention.repository.RoleRepository;
import mg.douane.intervention.service.AgentServiceImpl;
import mg.douane.intervention.service.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AccueilController {
    @Autowired
    AgentServiceImpl agentService;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategorieService categorieService;

    @Autowired
    CategorieRepository categorieRepository;

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

    @RequestMapping(value = "/post")
    public String gerePostPage(Model model) {
        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("roleList", roleRepository.findAll());
        return "Admin/GererPoste";
    }

    @RequestMapping("/addRole/{idRole}/{idAgent}")
    public String createRole(@PathVariable Long idRole, @PathVariable String idAgent) {
        Optional<Agent> agent = agentRepository.findById(idAgent);
        Optional<Role> role = roleRepository.findById(idRole);
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role.get());
        agent.get().setRoles(roleSet);
        agentRepository.save(agent.get());
        return "redirect:/agent";
    }

    @RequestMapping("/getRole/{idAgent}")
    public ResponseEntity<String> getRole(@PathVariable String idAgent) {
        Optional<Agent> agent = agentRepository.findById(idAgent);
        long roleGet = 0;
        for (Role role : agent.get().getRoles()) {
            roleGet = role.getIdRole();
        }
        return ResponseEntity.ok(roleGet + "");
    }

    @RequestMapping(value = "/hierarchie")
    public String gereHierarchiePage(Model model) {
        model.addAttribute("categList", categorieService.getAllCategories());
        return "Admin/GererHierarchie";
    }

    @RequestMapping("/addSousCat/{idCat}/{idSousCat}/{name}")
    public String addSousCat(@PathVariable Long idCat, @PathVariable Long idSousCat, @PathVariable String name) {
        Optional<Categorie> cat = categorieRepository.findById(idCat);
        if (idSousCat == 0) {
            Categorie sousCat = new Categorie();
            sousCat.setCat(cat.get());
            sousCat.setLibelleCat(name);
            sousCat.setDateDebCat(new Date());
            categorieRepository.save(sousCat);
        } else {
            Optional<Categorie> c = categorieRepository.findById(idSousCat);
            Categorie sousCat = new Categorie();
            sousCat.setCat(c.get());
            sousCat.setLibelleCat(name);
            sousCat.setDateDebCat(new Date());
            categorieRepository.save(sousCat);
        }

        return "redirect:/hierarchie";
    }

    @RequestMapping("/addCat/{name}")
    public String addCat(@PathVariable String name) {
        Categorie categorie = new Categorie();
        categorie.setLibelleCat(name);
        categorie.setDateDebCat(new Date());
        categorieRepository.save(categorie);
        return "redirect:/hierarchie";
    }

}
