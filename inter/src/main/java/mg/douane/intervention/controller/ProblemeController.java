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
import java.util.*;

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
        if (filter.equals("all"))
            model.addAttribute("problemList", problemeService.getAllProblemes());
        else if (filter.equals("resolu"))
            model.addAttribute("problemList", problemeService.getAllProblemesFilter("resolu"));
        else
            model.addAttribute("problemList", problemeService.getAllProblemesFilter("notresolu"));
        return "ListeToutProbleme";
    }

    @RequestMapping(value = "/problemView/{userName}")
    public String problemeView(Model model, @PathVariable(name = "userName") String userName) {
        model.addAttribute("problemList", problemeService.getAllProblemesByAgent(userName));
        model.addAttribute("problemtForm", new Probleme());
        model.addAttribute("categori", categorieRepository.findAll());
        model.addAttribute("prioriter", prioriterRepository.findAll());
        return "SignalerProbleme";
    }

    @RequestMapping(value = "/problemRecep/{userName}")
    public String problemRecep(Model model, @PathVariable(name = "userName") String userName) {
        model.addAttribute("problemList", problemeService.getAllProblemesByDest(userName));
        model.addAttribute("problemListNews", problemeService.getAllProblemesByDestNews(userName));
        model.addAttribute("problemListEnAttente", problemeService.getAllProblemesByDestEnAttente(userName));
        model.addAttribute("problemListResolu", problemeService.getAllProblemesByDestResolu(userName));
        model.addAttribute("agentList", agentRepository.findAll());
        return "Dispatch/ReceptionProblemeDispatch";
    }

    @GetMapping("/sousCategorieListe/{id}")
    @ResponseBody
    public List<SousCategorieDto> getSousCat(@PathVariable Long id) {
        List<SousCategorie> sousCategories = sousCategorieService.getAllSousCategoriesByCat(id);
        return getSousCategorieDtos(sousCategories);
    }

    @GetMapping("/sousCategorie2Liste/{id}")
    @ResponseBody
    public List<SousCategorieDto> getSousCats(@PathVariable Long id) {
        List<SousCategorie> sousCategories = sousCategorieService.getAllSousSousCategoriesBySous(id);
        return getSousCategorieDtos(sousCategories);
    }

    private List<SousCategorieDto> getSousCategorieDtos(List<SousCategorie> sousCategories) {
        List<SousCategorieDto> sousCategorieDtos = new ArrayList<>();
        for (int i = 0; i < sousCategories.size(); i++) {
            SousCategorieDto sousCategorieDto = new SousCategorieDto();
            sousCategorieDto.setIdSCat(sousCategories.get(i).getIdSCat());
            sousCategorieDto.setLibelleSCat(sousCategories.get(i).getLibelleSCat());
            try {
                sousCategorieDto.setIdSouSCat(sousCategories.get(i).getSCat().getIdSCat());
            } catch (Exception e) {
                sousCategorieDto.setIdSouSCat((long) 0);
            }
            sousCategorieDtos.add(sousCategorieDto);
        }
        sousCategorieDtos.sort(Comparator.comparing(SousCategorieDto::getIdSouSCat));
        return sousCategorieDtos;
    }

    @GetMapping("/getIntervenant/{id}")
    @ResponseBody
    public List<AgentDto> getIntervenant(@PathVariable Long id) {
        List<Agent> agents = problemeService.getIntervenant(id);
        List<AgentDto> agentDtos = new ArrayList<>();
        for (int i = 0; i < agents.size(); i++) {
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

        return "redirect:/problemView/" + ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    @RequestMapping(value = "/viewPblm/{id}")
    public String getViewPrblmForm(Model model, @PathVariable(name = "id") Long id) {
        Optional<Probleme> problemToView = null;
        try {
            problemToView = problemeRepository.findById(id);
            Optional<Statut> statut = statusrepository.findById((long) 2);
            problemToView.get().setStatut(statut.get());
            problemeRepository.save(problemToView.get());
        } catch (Exception e) {
        }
        List<Reponse> reponseView = reponseRepository.findByProblemeRep(problemToView.get());

        model.addAttribute("pblmView", problemToView.get());
        model.addAttribute("response", reponseView);
        return "Dispatch/DetailMessageDispatch";
    }

    @RequestMapping("/addRep/{idProb}/{desc}")
    public String addRep(@PathVariable long idProb, @PathVariable String desc) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Agent> agent = agentRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
        Optional<Probleme> prb = problemeRepository.findById(idProb);
        Reponse rep = new Reponse();
        rep.setDateEnvRep(new Date());
        rep.setLibelleRep("libel");
        rep.setDescriptionRep(desc);
        rep.setProblemeRep(prb.get());
        rep.setAgentRep(agent.get());
        reponseRepository.save(rep);
        return "redirect:/viewPblm/" + idProb;
    }

    @RequestMapping("/tranferer/{idAgent}/{idPrb}")
    public String tranferer(@PathVariable long idAgent, @PathVariable long idPrb) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Agent> agentOrg = agentRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
        Optional<Probleme> probleme = problemeRepository.findById(idPrb);
        try {
            String interTemp = probleme.get().getIntervenant();
            String[] interSplit = interTemp.split(",");
            if (interSplit.length > 0) {
                String temp = "";
                for (int i = 0; i < interSplit.length; i++) {
                    Optional<Agent> agentOptional = agentRepository.findById(interSplit[i]);
                    if (agentOrg.get() == agentOptional.get()) {
                        temp = temp + idAgent;
                    } else {
                        temp = temp + agentOptional.get().getNumMatAgent();
                    }
                    temp = temp + ",";
                }
                probleme.get().setIntervenant(temp.substring(0, temp.length() - 1));
                problemeRepository.save(probleme.get());
            }
        } catch (Exception e) {
        }
        return "redirect:/problemRecep/" + ((UserDetails) authentication.getPrincipal()).getUsername();
    }
}
