package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.data.dto.ChangePasswordDto;
import mg.douane.intervention.data.dto.HierarchieDto;
import mg.douane.intervention.data.dto.QuartierDto;
import mg.douane.intervention.repository.*;
import mg.douane.intervention.service.AgentService;
import mg.douane.intervention.service.HierarchieService;
import mg.douane.intervention.service.QuartierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TypeHierarchieRepository typeHierarchieRepository;

    @Autowired
    HierarchieRepository hierarchieRepository;

    @Autowired
    HierarchieService hierarchieService;

    @Autowired
    PosteRepository posteRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    PorteRepository porteRepository;

    @Autowired
    QuartierService quartierService;

    @Autowired
    SousCategoriRepository sousCategoriRepository;

    @Autowired
    FichePosteRepository fichePosteRepository;

    @RequestMapping(value = { "/", "/login" })
    public String index() {
        return "index";
    }

    // @GetMapping("/userForm")
    @RequestMapping(value = "/agentForm")
    public String userForm(Model model) {
        model.addAttribute("agentForm", new Agent());
        model.addAttribute("fichePosteForm", new FichePoste());
        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("typeHierarchie", typeHierarchieRepository.findAll());
        model.addAttribute("postes", posteRepository.findAll());
        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("portes", porteRepository.findAll());
        model.addAttribute("souscateg", sousCategoriRepository.findAll());
        return "register";
    }

    @GetMapping("/hierarchieList/{id}")
    @ResponseBody
    public List<HierarchieDto> getHierarchie(@PathVariable Long id){
        List<Hierarchie> hierarchies = hierarchieService.getHierarchieByTypeHierarchie(id);
        List<HierarchieDto> hierarchieDtos = new ArrayList<>();
        for(int i = 0; i< hierarchies.size(); i++) {
            HierarchieDto hierarchieDto = new HierarchieDto();
            hierarchieDto.setIdHier(hierarchies.get(i).getIdHier());
            hierarchieDto.setLibelleHier(hierarchies.get(i).getLibelleHier());
            hierarchieDtos.add(hierarchieDto);
        }
        return hierarchieDtos;
    }

    @GetMapping("/quartierList/{id}")
    @ResponseBody
    public List<QuartierDto> getQuartier(@PathVariable Long id){
        List<Quartier> quartiers = quartierService.getQuartierByVille(id);
        List<QuartierDto> quartierDtos = new ArrayList<>();
        for(int i = 0; i< quartiers.size(); i++) {
            QuartierDto quartierDto = new QuartierDto();
            quartierDto.setIdQuartier(quartiers.get(i).getIdQuartier());
            quartierDto.setLibelleQuartier(quartiers.get(i).getLibelleQuartier());
            quartierDtos.add(quartierDto);
        }
        return quartierDtos;
    }

    @PostMapping("/agentForm")
    public String createAgent(@Valid @ModelAttribute("agentForm") Agent agent, @ModelAttribute("fichePosteForm") FichePoste fichePoste, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("agentForm", agent);
            model.addAttribute("formTab", "active");
        } else {
            try {
                Agent agnt = agentService.createAgent(agent);
                Optional<Hierarchie> hierarchie = hierarchieRepository.findById(fichePoste.getHierarchieFich().getIdHier());
                Optional<Poste> poste = posteRepository.findById(fichePoste.getPosteFich().getIdPoste());
                Optional<SousCategorie> sousCategorie = sousCategoriRepository.findById(fichePoste.getSouCatFich().getIdSCat());
                fichePoste.setAgentFich(agnt);
                fichePoste.setHierarchieFich(hierarchie.get());
                fichePoste.setPosteFich(poste.get());
                fichePoste.setSouCatFich(sousCategorie.get());
                fichePosteRepository.save(fichePoste);
                model.addAttribute("agentForm", new Agent());
                model.addAttribute("listTab", "active");

            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
                model.addAttribute("agentForm", agent);
                model.addAttribute("formTab", "active");
                model.addAttribute("agentList", agentService.getAllAgents());
                model.addAttribute("roles", roleRepository.findAll());
            }
        }

        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("roles", roleRepository.findAll());
        // return "agent-form/agent-view";
        return "redirect:/login";
    }

    // @GetMapping("/editAgent/{id}")
    @RequestMapping(value = "/editAgent/{id}")
    public String getEditUserForm(Model model, @PathVariable(name = "id") String id) throws Exception {
        Agent userToEdit = agentService.getAgentById(id);

        model.addAttribute("agentForm", userToEdit);
        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("formTab", "active");
        model.addAttribute("editMode", "true");
        model.addAttribute("passwordForm", new ChangePasswordDto(id));

        return "agent-form/agent-view";
    }

    @PostMapping("/editAgent")
    public String postEditUserForm(@Valid @ModelAttribute("agentForm") Agent agent, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("agentForm", agent);
            model.addAttribute("formTab", "active");
            model.addAttribute("editMode", "true");
            model.addAttribute("passwordForm", new ChangePasswordDto(agent.getNumMatAgent()));
        } else {
            try {
                agentService.updateAgent(agent);
                model.addAttribute("userForm", new Agent());
                model.addAttribute("listTab", "active");
            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
                model.addAttribute("agentForm", agent);
                model.addAttribute("formTab", "active");
                model.addAttribute("agentList", agentService.getAllAgents());
                model.addAttribute("roles", roleRepository.findAll());
                model.addAttribute("editMode", "true");
                model.addAttribute("passwordForm", new ChangePasswordDto(agent.getNumMatAgent()));
            }
        }

        model.addAttribute("agentList", agentService.getAllAgents());
        model.addAttribute("roles", roleRepository.findAll());
        // return "agent-form/agent-view";
        return "redirect:/agentForm";

    }

    // @GetMapping("/agentForm/cancel")
    @RequestMapping(value = "/agentForm/cancel")
    public String cancelEditAgent(ModelMap model) {
        return "redirect:/agentForm";
    }

    // @GetMapping("/deleteAgent/{id}")
    @RequestMapping(value = "/deleteAgent/{id}")
    public String deleteUser(Model model, @PathVariable(name = "id") String id) {
        try {
            agentService.deleteAgent(id);
        } catch (Exception e) {
            model.addAttribute("listErrorMessage", e.getMessage());
        }
        // return agentForm(model);
        return "redirect:/agentForm";
    }

    @PostMapping("/editAgent/changePassword")
    public ResponseEntity<String> postEditUseChangePassword(@Valid @RequestBody ChangePasswordDto form, Errors errors) {
        try {
            if (errors.hasErrors()) {
                String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

                throw new Exception(result);
            }
            agentService.ChangePasswordDto(form);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }
}
