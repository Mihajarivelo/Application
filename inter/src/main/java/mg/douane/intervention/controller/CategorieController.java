package mg.douane.intervention.controller;

import mg.douane.intervention.service.CategoriService;
import mg.douane.intervention.service.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategorieController {
    @Autowired
    CategoriService categoriService;

    @Autowired
    SousCategorieService sousCategorieService;

    @RequestMapping(value = "/problemeCateg")
    public String categoriePage(Model model) {
        model.addAttribute("categList", categoriService.getAllCategories());
        model.addAttribute("souscategList", sousCategorieService.getAllSousCategories());
        model.addAttribute("soussouscategList", sousCategorieService.getAllSousSousCategories());
        return "ListeCategorie";
    }
}
