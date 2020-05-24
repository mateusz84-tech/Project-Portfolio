package pl.matkoc.Approval_material.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.matkoc.Approval_material.utils.SecurityUtils;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("username", SecurityUtils.username());
        return "home-page";
    }
}
