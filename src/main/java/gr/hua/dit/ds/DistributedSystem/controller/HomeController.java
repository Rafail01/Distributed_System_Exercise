package gr.hua.dit.ds.DistributedSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/api")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}