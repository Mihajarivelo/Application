package mg.douane.intervention.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

    @RequestMapping(value = "/home")
    public String accueilPage(Model model) {
        return "home";
    }
}
