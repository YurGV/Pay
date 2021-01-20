package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CardAccoutController {

    @Autowired
    private UserService userService;

    @GetMapping("/replenishment")
    public String getLogin(Model model) {
        //model.addAttribute("login", "login");
        return ("replenishment");
    }

//    @GetMapping("/add")
//    public String add(Model model) {
//        //model.addAttribute("login", "login");
//        return ("addCard");
//    }


}
