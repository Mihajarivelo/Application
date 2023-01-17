package mg.douane.intervention.controller;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.data.dto.CategorieDto;
import mg.douane.intervention.data.dto.HierarchieDto;
import mg.douane.intervention.repository.*;
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

    @Autowired
    HierarchieRepository hierarchieRepository;

    @Autowired
    TypeHierarchieRepository typeHierarchieRepository;

    @RequestMapping(value = "/home")
    public String accueilPage(Model model) {
        return "home";
    }


    @RequestMapping("/addRole/{idRole}/{idAgent}")
    public String createRole(@PathVariable Long idRole, @PathVariable long idAgent) {
        Optional<Agent> agent = agentRepository.findById(idAgent);
        Optional<Role> role = roleRepository.findById(idRole);
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role.get());
        agent.get().setRoles(roleSet);
        agentRepository.save(agent.get());
        return "redirect:/agent";
    }

    @RequestMapping("/getRole/{idAgent}")
    public ResponseEntity<String> getRole(@PathVariable Long idAgent) {
        Optional<Agent> agent = agentRepository.findById(idAgent);
        long roleGet = 0;
        for (Role role : agent.get().getRoles()) {
            roleGet = role.getIdRole();
        }
        return ResponseEntity.ok(roleGet + "");
    }

    @RequestMapping(value = "/categorie")
    public String gereCategoriePage(Model model) {
        model.addAttribute("categList", categorieService.getAllCategories());
        return "Admin/GererCategorie";
    }

    @RequestMapping(value = "/hierarchie")
    public String gereHierarchiePage(Model model) {
        model.addAttribute("hierarListe", hierarchieRepository.findAll());
        model.addAttribute("typeHierListe", typeHierarchieRepository.findAll());
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

        return "redirect:/categorie";
    }

    @RequestMapping("/addCat/{name}")
    public String addCat(@PathVariable String name) {
        Categorie categorie = new Categorie();
        categorie.setLibelleCat(name);
        categorie.setDateDebCat(new Date());
        categorieRepository.save(categorie);
        return "redirect:/categorie";
    }

    @RequestMapping("/addHierarchie/{name}/{type}")
    public String addHierarchie(@PathVariable String name, @PathVariable long type) {
        Hierarchie hierarchie = new Hierarchie();
        hierarchie.setLibelleHier(name);
        hierarchie.setDateDebHier(new Date());
        Optional<TypeHierarchie> typeHierarchie = typeHierarchieRepository.findById(type);
        hierarchie.setType(typeHierarchie.get());
        hierarchieRepository.save(hierarchie);
        return "redirect:/hierarchie";
    }

    @RequestMapping("/addSouHierarchie/{idH}/{name}")
    public String addHierarchie(@PathVariable long idH,  @PathVariable String name) {
        Hierarchie hierarchie = new Hierarchie();
        hierarchie.setLibelleHier(name);
        hierarchie.setDateDebHier(new Date());
        Optional<Hierarchie> hierarchieOptional = hierarchieRepository.findById(idH);
        Optional<TypeHierarchie> typeHierarchie = typeHierarchieRepository.findById(hierarchieOptional.get().getType().getIdType());
        hierarchie.setHier(hierarchieOptional.get());
        hierarchie.setType(typeHierarchie.get());
        hierarchieRepository.save(hierarchie);
        return "redirect:/hierarchie";
    }

    @GetMapping("/sousHierarchie/{id}")
    @ResponseBody
    public List<HierarchieDto> getSousHier(@PathVariable Long id) {
        Optional<Hierarchie> hier = hierarchieRepository.findById(id);
        List<Hierarchie> sousHier = hierarchieRepository.findByHier(hier.get());
        List<HierarchieDto> hierarchieDtos = new ArrayList<>();
        for (int i = 0; i < sousHier.size(); i++) {
            Set<Hierarchie> ct = sousHier.get(i).getListHier();
            List<Hierarchie> lc = new ArrayList<Hierarchie>(ct);
            if (lc.size() > 0) {
                HierarchieDto cdt = new HierarchieDto();
                cdt.setIdHier(sousHier.get(i).getIdHier());
                cdt.setLibelleHier(sousHier.get(i).getLibelleHier());
                cdt.setIdShier((long) 0);
                hierarchieDtos.add(cdt);
                for (int j = 0; j < lc.size(); j++) {
                    HierarchieDto sousHierto = new HierarchieDto();
                    sousHierto.setIdShier(sousHier.get(i).getIdHier());
                    sousHierto.setLibelleHier(lc.get(j).getLibelleHier());
                    try {
                        sousHierto.setIdHier(lc.get(j).getIdHier());
                    } catch (Exception e) {
                        sousHierto.setIdHier((long) 0);
                    }
                    hierarchieDtos.add(sousHierto);
                    Set<Hierarchie> ctt = lc.get(j).getListHier();
                    List<Hierarchie> lct = new ArrayList<Hierarchie>(ctt);
                    if (lct.size() > 0) {
                        for (int n = 0; n < lct.size(); n++) {
                            sousHierto = new HierarchieDto();
                            sousHierto.setIdShier(lc.get(j).getIdHier());
                            sousHierto.setLibelleHier(lct.get(n).getLibelleHier());
                            try {
                                sousHierto.setIdHier(lct.get(n).getIdHier());
                            } catch (Exception e) {
                                sousHierto.setIdHier((long) 0);
                            }
                            hierarchieDtos.add(sousHierto);
                        }
                    }
                }

            } else {
                HierarchieDto soushierDto = new HierarchieDto();
                soushierDto.setIdHier(sousHier.get(i).getIdHier());
                soushierDto.setLibelleHier(sousHier.get(i).getLibelleHier());
                soushierDto.setIdShier((long) 0);
                hierarchieDtos.add(soushierDto);

            }

        }
        hierarchieDtos.sort(Comparator.comparing(HierarchieDto::getIdHier));
        return hierarchieDtos;
    }

}
