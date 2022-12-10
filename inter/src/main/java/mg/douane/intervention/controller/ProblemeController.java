package mg.douane.intervention.controller;

import mg.douane.intervention.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProblemeController {

    @Autowired
    ProblemeService problemeService;

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
}
