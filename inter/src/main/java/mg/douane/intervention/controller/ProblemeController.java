package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.data.dto.AgentDto;
import mg.douane.intervention.data.dto.CategorieDto;
import mg.douane.intervention.data.dto.FichePosteDto;
import mg.douane.intervention.repository.*;
import mg.douane.intervention.service.AgentService;
import mg.douane.intervention.service.CategorieService;
import mg.douane.intervention.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    CategorieService categorieService;

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

    @Autowired
    AgentService agentService;

    @Autowired
    FichePosteRepository fichePosteRepository;

    @Autowired
    IntervenantRepository intervenantRepository;

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
        model.addAttribute("categori", categorieRepository.findAllCategories());
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
        model.addAttribute("categori", categorieRepository.findAllCategories());
        model.addAttribute("prioriter", prioriterRepository.findAll());
        model.addAttribute("problemtForm", new Probleme());
        return "Dispatch/ReceptionProblemeDispatch";
    }

    @GetMapping("/sousCategorieListe/{id}")
    @ResponseBody
    public List<CategorieDto> getSousCat(@PathVariable Long id) {
        List<Categorie> sousCategories = categorieService.getAllSousCategoriesByCat(id);
        return getSousCategorieDtos(sousCategories);
    }

    @GetMapping("/getSousCategorieListe/{id}")
    @ResponseBody
    public List<CategorieDto> getSousCategorie(@PathVariable Long id) {
        List<Categorie> sousCategories = categorieService.getAllSousCategoriesByCat(id);
        List<CategorieDto> categorieDtos = new ArrayList<>();
        for (int i = 0; i < sousCategories.size(); i++) {
            CategorieDto categorieDto = new CategorieDto();
            categorieDto.setIdCat(sousCategories.get(i).getIdCat());
            categorieDto.setLibelleCat(sousCategories.get(i).getLibelleCat());
            categorieDtos.add(categorieDto);
        }
        return categorieDtos;
    }

    @GetMapping("/sousCategorie2Liste/{id}")
    @ResponseBody
    public List<CategorieDto> getSousCats(@PathVariable Long id) {
        List<Categorie> sousCategories = categorieService.getAllSousSousCategoriesBySous(id);
        return getSousCategorieDtos(sousCategories);
    }

    private List<CategorieDto> getSousCategorieDtos(List<Categorie> sousCategories) {
        List<CategorieDto> categorieDtos = new ArrayList<>();
        for (int i = 0; i < sousCategories.size(); i++) {
            Set<Categorie> ct = sousCategories.get(i).getScats();
            List<Categorie> lc = new ArrayList<Categorie>(ct);
            if (lc.size() > 0) {
                CategorieDto cdt = new CategorieDto();
                cdt.setIdCat(sousCategories.get(i).getIdCat());
                cdt.setLibelleCat(sousCategories.get(i).getLibelleCat());
                cdt.setIdSCat((long) 0);
                categorieDtos.add(cdt);
                for (int j = 0; j < lc.size(); j++) {
                    CategorieDto sousCategorieDto = new CategorieDto();
                    sousCategorieDto.setIdSCat(sousCategories.get(i).getIdCat());
                    sousCategorieDto.setLibelleCat(lc.get(j).getLibelleCat());
                    try {
                        sousCategorieDto.setIdCat(lc.get(j).getIdCat());
                    } catch (Exception e) {
                        sousCategorieDto.setIdCat((long) 0);
                    }
                    categorieDtos.add(sousCategorieDto);
                    Set<Categorie> ctt = lc.get(j).getScats();
                    List<Categorie> lct = new ArrayList<Categorie>(ctt);
                    if (lct.size() > 0) {
                        for (int n = 0; n < lct.size(); n++) {
                            sousCategorieDto = new CategorieDto();
                            sousCategorieDto.setIdSCat(lc.get(j).getIdCat());
                            sousCategorieDto.setLibelleCat(lct.get(n).getLibelleCat());
                            try {
                                sousCategorieDto.setIdCat(lct.get(n).getIdCat());
                            } catch (Exception e) {
                                sousCategorieDto.setIdCat((long) 0);
                            }
                            categorieDtos.add(sousCategorieDto);
                        }
                    }
                }

            } else {
                CategorieDto sousCategorieDto = new CategorieDto();
                sousCategorieDto.setIdCat(sousCategories.get(i).getIdCat());
                sousCategorieDto.setLibelleCat(sousCategories.get(i).getLibelleCat());
                sousCategorieDto.setIdSCat((long) 0);
                categorieDtos.add(sousCategorieDto);

            }

        }
        categorieDtos.sort(Comparator.comparing(CategorieDto::getIdCat));
        return categorieDtos;
    }

    @GetMapping("/getIntervenant/{id}")
    @ResponseBody
    public List<AgentDto> getIntervenant(@PathVariable Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        List<FichePoste> fichePostes = fichePosteRepository.findByCatFich(categorie.get());
        List<AgentDto> agentDtos = new ArrayList<>();
        for (int i = 0; i < fichePostes.size(); i++) {
            AgentDto agentDto = new AgentDto();
            agentDto.setNumMatAgent(fichePostes.get(i).getAgentFich().getNumMatAgent());
            agentDto.setNomAgent(fichePostes.get(i).getAgentFich().getNomAgent());
            agentDto.setPrenomAgent(fichePostes.get(i).getAgentFich().getPrenomAgent());
            agentDtos.add(agentDto);
        }
        return agentDtos;
    }

    @PostMapping("/addPrblm")
    public String createPrblm(@Valid @ModelAttribute("problemtForm") Probleme probleme, @Valid @ModelAttribute("intervenant") String intervenant,
                              @Valid @ModelAttribute("idProbMer") long idProbMer, BindingResult result,
                              ModelMap model) {
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
                try{
                    Optional<Probleme> problemeOptional = problemeRepository.findById(idProbMer);
                    problemeAdd.setProb(problemeOptional.get());
                } catch (Exception e) {}
                Probleme saveProb = problemeRepository.save(problemeAdd);

                Intervenant interv = new Intervenant();
                Optional<Agent> agentOptional = agentRepository.findById(intervenant);
                interv.setAgentInt(agentOptional.get());
                interv.setProbInt(saveProb);
                intervenantRepository.save(interv);

                model.addAttribute("problemtForm", new Probleme());
            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
            }
        }

        return "redirect:/problemView/" + ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    @RequestMapping(value = "/viewPblm/{id}")
    public String getViewPrblmForm(Model model, @PathVariable(name = "id") Long id) {
        Optional<Probleme> problemToView = problemeRepository.findById(id);
        try {
            Optional<Statut> statut = statusrepository.findById((long) 2);
            problemToView.get().setStatut(statut.get());
            problemeRepository.save(problemToView.get());
        } catch (Exception e) {
        }
        List<Reponse> reponseView = reponseRepository.findByProblemeRep(problemToView.get());

        model.addAttribute("pblmView", problemToView.get());
        model.addAttribute("response", reponseView);
        model.addAttribute("orgPrblm", problemToView.get().getAgentProb());
        try {
            model.addAttribute("lasteResponse", reponseView.get(reponseView.size() - 1));
        } catch (Exception e) {
            model.addAttribute("lasteResponse", new Reponse());
        }
        return "Dispatch/DetailMessageDispatch";
    }

    @RequestMapping("/addRep/{idProb}/{desc}")
    public String addRep(@PathVariable long idProb, @PathVariable String desc) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Agent> agent = agentRepository
                .findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
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

    @RequestMapping("/resolveprbm/{idProb}")
    public String addRep(@PathVariable long idProb) {
        Optional<Probleme> prb = problemeRepository.findById(idProb);
        Optional<Statut> statut = statusrepository.findById((long) 3);
        prb.get().setStatut(statut.get());
        Probleme p = problemeRepository.save(prb.get());
        return "redirect:/viewPblm/" + idProb;
    }

    @RequestMapping("/tranferer/{idAgent}/{idPrb}")
    public String tranferer(@PathVariable long idAgent, @PathVariable long idPrb) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Optional<Agent> agentOrg = agentRepository
                .findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
        Optional<Probleme> probleme = problemeRepository.findById(idPrb);
        try {
            // String interTemp = probleme.get().getIntervenant();
            // String[] interSplit = interTemp.split(",");
            // if (interSplit.length > 0) {
            // String temp = "";
            // for (int i = 0; i < interSplit.length; i++) {
            // Optional<Agent> agentOptional = agentRepository.findById(interSplit[i]);
            // if (agentOrg.get() == agentOptional.get()) {
            // temp = temp + idAgent;
            // } else {
            // temp = temp + agentOptional.get().getNumMatAgent();
            // }
            // temp = temp + ",";
            // }
            // probleme.get().setIntervenant(temp.substring(0, temp.length() - 1));
            // problemeRepository.save(probleme.get());
            // }
        } catch (Exception e) {
        }
        return "redirect:/problemRecep/" + ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    @RequestMapping(value = "/fichPoste")
    public String fichePoste(Model model) {
        model.addAttribute("agentList", agentService.getAllAgentsWithFiche());
        model.addAttribute("categList", categorieRepository.findAllCategories());
        model.addAttribute("ficheList", fichePosteRepository.findAll());

        return "Dispatch/GererFichePosteDispatch";
    }

    @RequestMapping("/getAgent/{idAgent}")
    public ResponseEntity<FichePosteDto> getAgent(@PathVariable String idAgent) {
        Optional<Agent> agentOrg = agentRepository.findById(idAgent);
        FichePoste fichePoste = fichePosteRepository.findByAgentFich(agentOrg.get());
        FichePosteDto fichePosteDto = new FichePosteDto();
        try {
            fichePosteDto.setIdFich(fichePoste.getIdFich());
        } catch (Exception e) {
        }
        fichePosteDto.setNameAgent(agentOrg.get().getNomAgent() + ' ' + agentOrg.get().getPrenomAgent());
        try {
            fichePosteDto.setFonction(fichePoste.getPosteFich().getFonctionPoste());
        } catch (Exception e) {
        }
        try {
            fichePosteDto.setHierarchie(fichePoste.getPosteFich().getHierarchiePoste().getLibelleHier());
        } catch (Exception e) {
        }
        try {
            fichePosteDto.setNumMatr(agentOrg.get().getNumMatAgent());
        } catch (Exception e) {
        }
        return ResponseEntity.ok(fichePosteDto);
    }

    @RequestMapping(value = "/saveFiche/{idCat}/{idFiche}")
    public String saveFiche(@PathVariable long idCat, @PathVariable long idFiche) {
        Optional<Categorie> categorie = categorieRepository.findById(idCat);
        Optional<FichePoste> fichePoste = fichePosteRepository.findById(idFiche);
        fichePoste.get().setCatFich(categorie.get());
        fichePosteRepository.save(fichePoste.get());
        return "redirect:/fichPoste";
    }


}
