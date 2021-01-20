package by.grodno.pvt.site.webappsample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/lllogin")
    public String getLogin(Model model) {
        //model.addAttribute("login", "login");
        return ("llloginPage");
    }

}
