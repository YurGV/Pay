package by.grodno.pvt.site.webappsample.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping("/w")
    public String getAllUsers(Model model) {
        model.addAttribute("massage", "Bank Online System from Yura");
        return "welcom";
    }
}
