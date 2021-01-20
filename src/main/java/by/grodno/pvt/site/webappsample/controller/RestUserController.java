package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.service.UserService;
import by.grodno.pvt.site.webappsample.service.impl.JPAUserService;
import com.google.common.util.concurrent.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestUserController {
    @Autowired
    private JPAUserService service;

//    @GetMapping("/test/user/{id}")
//    public OldUser getUserById(@PathVariable Integer id) {
//        return service.getUser(id);
//    }
//
//    @PutMapping("/test/user/{id}")
//    public void updateUser(@RequestBody OldUser user) {
//        service.updateUserName(user);
//    }
//    @GetMapping("/editOne/{id}")
//    public OldUser getCardById(@PathVariable Integer id) {
//     //   return "editOne";
//       return service.getUser(id);
//    }
//
//    @PostMapping("/editOne/{id}")
//    public void updateCardName(@RequestParam String Name, @RequestParam Integer id) {
//     //   user.updateUserName("newCard");
//        service.updateUserName(Name, id);
//    }
//
//    @Autowired
//    private UserService userService;


//    @GetMapping("/editOne/{id}")
//    public String editOne(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("user", service.getUser(id));
//
//        OldUser user = new OldUser();
//        user.setId(id);
//        user.setCardName("CardochKa");
//        service.updateUserName("cardName", id);
//
//        return "redirect:/users";
//        return "redirect:/users";
//    }


}
