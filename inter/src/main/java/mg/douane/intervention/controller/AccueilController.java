package mg.douane.intervention.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

    @RequestMapping(value = "/home")
    public String accueilPage(Model model) {
        return "home-view";
    }


    @RequestMapping(value = "/problem")
    public String interventionPage(Model model) {
        return "intervention-view";
    }

    @RequestMapping(value = "/user")
    public String userPage(Model model) {
        return "user-view";
    }

    @RequestMapping(value = "/userForm")
    public String userFormPage(Model model) {
        return "user-form";
    }

    @RequestMapping(value = "/problemeCateg")
    public String categoriePage(Model model) {
        return "problem-categori-view";
    }

    @RequestMapping(value = "/problemAutre")
    public String problemPage(Model model) {
        return "problem-view";
    }
}
