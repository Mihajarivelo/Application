package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.data.dto.AgentDto;
import mg.douane.intervention.data.dto.SousCategorieDto;
import mg.douane.intervention.repository.*;
import mg.douane.intervention.service.AgentService;
import mg.douane.intervention.service.ProblemeService;
import mg.douane.intervention.service.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProblemeController {

    @Autowired
    ProblemeService problemeService;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    SousCategorieService sousCategorieService;

    @Autowired
    PrioriterRepository prioriterRepository;

    @Autowired
    ProblemeRepository problemeRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    Statusrepository statusrepository;

    @Autowired
    ReponseRepository reponseRepository;

    @RequestMapping(value = "/problemeList/{filter}")
    public String problemePage(Model model, @PathVariable(name = "filter") String filter) {
        if(filter.equals("all"))
            model.addAttribute("problemList", problemeService.getAllProblemes());
        else if(filter.equals("resolu"))
            model.addAttribute("problemList", problemeService.getAllProblemesFilter("resolu"));
        else
            model.addAttribute("problemList", problemeService.getAllProblemesFilter("notresolu"));
        return "ListeToutProbleme";
    }

    @RequestMapping(value = "/problemView/{userName}")
    public String problemeView(Model model,@PathVariable(name = "userName") String userName) {
        model.addAttribute("problemList", problemeService.getAllProblemesByAgent(userName));
        model.addAttribute("problemtForm", new Probleme());
        model.addAttribute("categori", categorieRepository.findAll());
        model.addAttribute("prioriter", prioriterRepository.findAll());
        return "SignalerProbleme";
    }

    @GetMapping("/sousCategorieListe/{id}")
    @ResponseBody
    public List<SousCategorieDto> getSousCat(@PathVariable Long id){
        List<SousCategorie> sousCategories = sousCategorieService.getAllSousCategoriesByCat(id);
        return getSousCategorieDtos(sousCategories);
    }

    @GetMapping("/sousCategorie2Liste/{id}")
    @ResponseBody
    public List<SousCategorieDto> getSousCats(@PathVariable Long id){
        List<SousCategorie> sousCategories = sousCategorieService.getAllSousSousCategoriesBySous(id);
        return getSousCategorieDtos(sousCategories);
    }

    private List<SousCategorieDto> getSousCategorieDtos(List<SousCategorie> sousCategories) {
        List<SousCategorieDto> sousCategorieDtos = new ArrayList<>();
        for(int i = 0; i< sousCategories.size(); i++) {
            SousCategorieDto sousCategorieDto = new SousCategorieDto();
            sousCategorieDto.setIdSCat(sousCategories.get(i).getIdSCat());
            sousCategorieDto.setLibelleSCat(sousCategories.get(i).getLibelleSCat());
            sousCategorieDtos.add(sousCategorieDto);
        }
        return sousCategorieDtos;
    }

    @GetMapping("/getIntervenant/{id}")
    @ResponseBody
    public List<AgentDto> getIntervenant(@PathVariable Long id){
        List<Agent> agents = problemeService.getIntervenant(id);
        List<AgentDto> agentDtos = new ArrayList<>();
        for(int i=0; i < agents.size(); i++) {
            AgentDto agentDto = new AgentDto();
            agentDto.setNumMatAgent(agents.get(i).getNumMatAgent());
            agentDto.setNomAgent(agents.get(i).getNomAgent());
            agentDto.setPrenomAgent(agents.get(i).getPrenomAgent());
            agentDtos.add(agentDto);
        }
        return agentDtos;
    }

    @PostMapping("/addPrblm")
    public String createPrblm(@Valid @ModelAttribute("problemtForm") Probleme probleme, BindingResult result, ModelMap model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (result.hasErrors()) {
            model.addAttribute("problemtForm", probleme);
        } else {
            try {
                Probleme problemeAdd = probleme;
                problemeAdd.setDateEnvProb(new Date());
                Optional<Agent> agent = agentRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
                problemeAdd.setAgentProb(agent.get());
                Optional<Statut> statut = statusrepository.findById((long) 1);
                problemeAdd.setStatut(statut.get());
                problemeRepository.save(probleme);
                model.addAttribute("problemtForm", new Probleme());
            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
            }
        }

        return "redirect:/problemView/"+((UserDetails) authentication.getPrincipal()).getUsername();
    }

    @GetMapping("/problemeReception/{userName}")
    public String problemeRecpt(Model model,@PathVariable(name = "userName") String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        model.addAttribute("problemList", problemeRepository.findByIntervenant(agent.get().getNumMatAgent()));
        model.addAttribute("problemListNews", problemeService.getAllProblemesByAgent(userName));
        model.addAttribute("problemListEnCours", problemeService.getAllProblemesByAgent(userName));
        model.addAttribute("problemListResolu", problemeService.getAllProblemesByAgent(userName));
        return "Dispatch/ReceptionProblemeDispatch";
    }

    @RequestMapping(value = "/viewPblm/{id}")
    public String getViewPrblmForm(Model model, @PathVariable(name = "id") Long id) {
        Probleme problemToView = null;
        try {
            problemToView = problemeService.getPrbById(id);
        } catch (Exception e) {
        }
        List<Reponse> reponseView = reponseRepository.findByProblemeRep(problemToView);

        model.addAttribute("pblmView", problemToView);
        model.addAttribute("response", reponseView);
        return "Dispatch/DetailMessageDispatch";
    }
}
