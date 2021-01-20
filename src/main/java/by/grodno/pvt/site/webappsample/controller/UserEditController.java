package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.UserDTO;
import by.grodno.pvt.site.webappsample.dto.UserEx;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;
import by.grodno.pvt.site.webappsample.service.impl.JPAUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserEditController {

    @Autowired
    private UserService userService;

    public UserEditController() {
    }

    @GetMapping("/user-edit")
    public String editUserForm(Model model) {
        return "userEdit";
    }

     @Autowired
    private ConversionService convertionService;


    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id,
                           @RequestParam(value="cardName") String cardName,
                           @RequestParam(value="balance") Double balance,
                           @RequestParam(value="valid") Integer valid,
                     //      @RequestParam(value="avatarFileName") String avatarFileName,
                           @RequestParam(value="lock") Boolean lock,
                           @RequestParam(value="username") String username,
                           @RequestParam(value="password") String password) {
                      //     @RequestParam(value="role") String role


       OldUser user = new OldUser();
       user.setId(id);
       user.setCardName(cardName);
       user.setBalance(balance);
       user.setValid(valid);
//     user.setAvatarFileName(avatarFileName);
       user.setLock(lock);
       user.setUsername(username);
       user.setPassword(password);
       user.setRole("USER");


       userService.saveUser(user);

      return "redirect:/users";
// OldUser oldUser = new OldUser(null, "Visa", 100.01, 2021, "a;slfjghhzbzygh", true, "max","max","ADMIN");

 }
//    @GetMapping("/lock/{id}")
//    public String cardLock(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("user", userService.getUser(id));
//
//        OldUser user = new OldUser();
//        user.setId(id);
//        user.setLock(false);
//        userService.saveUser(user);
//
//        return "redirect:/users";
//
//    }

//    @GetMapping("/unlock/{id}")
//    public String cardUnlock(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("user", userService.getUser(id));
//
//        OldUser user = new OldUser();
//        user.setId(id);
//        user.setLock(true);
//        userService.saveUser(user);
//
//        return "redirect:/users";
//    }


//    @GetMapping("/replenishment/{id}")
//    public String replenishment(@PathVariable Integer id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "replenishment";
//    }
//
//    @PostMapping("/replenishment/{id}")
//    public String replenishment(@PathVariable Integer id,
//                             //   @RequestParam(value="cardName") String cardName,
//                                @RequestParam(value="balance") Double balance,
//                           //     @RequestParam(value="valid") Integer valid,
//                           //     @RequestParam(value="avatarFileName") String avatarFileName,
//                          //      @RequestParam(value="lock") Boolean lock,
//                          //      @RequestParam(value="username") String username,
//                         //       @RequestParam(value="password") String password,
//                                Model model) {
//
//        model.addAttribute("user", userService.getUser(id));
//
//        OldUser user = new OldUser();
//        user.setId(id);
//  //      user.setCardName(cardName);
//        user.setBalance(balance = balance + 9999 );
////        user.setValid(valid);
////        user.setAvatarFileName(avatabaileName);
////        user.setLock(lock);
////        user.setUsername(username);
////        user.setPassword(password);
////        user.setRole("USER");
//
//        userService.saveUser(user);
//
//        return "redirect:/users";
//
//    }
//    @GetMapping("/editOne/{id}")
//    public String editOne(@PathVariable Integer id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "editOne";
//    }
//
//    @PostMapping("/editOne/{id}")
//    public String editOne(@PathVariable Integer id,
//                          @RequestParam(value="cardName") String cardName,
//                          Model model) {
//
//        model.addAttribute("user", userService.getUser(id));
//
//        OldUser user = new OldUser();
//        user.setId(id);
//        user.setCardName(cardName);
//        //user.setBalance(balance = balance + 9999 );
//        userService.saveUser(user);
//
//        return "redirect:/users";
//    }


    @Autowired
    private JPAUserService service;
//--------------------РАБОТАЕТ---------------
//    @GetMapping("/editOne/{id}")                        //изменение одного филда для id
//    public String editOne(@PathVariable Integer id) {
//        service.updateUserName("newName", id);
//        return "redirect:/users";
//    }

    @GetMapping("/editOne/{id}")                        //изменение одного филда для id с редактирование на странице
    public String editOneForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "editOne";
    }
    @PostMapping("/editOne/{id}")
    public String editOneUpdate(@PathVariable Integer id,
                                @RequestParam(value="cardName") String cardName) {
        service.updateUserName(cardName, id);
        return "redirect:/users";

    }

        @GetMapping("/lock/{id}")                        //изменение на статус Lock
    public String editStatusLock(@PathVariable Integer id) {
        service.updateStatusCard(false, id);
        return "redirect:/users";
    }

    @GetMapping("/unlock/{id}")                        //изменение на статус UnLock
    public String editStatusUnlock(@PathVariable Integer id) {
        service.updateStatusCard(true, id);
        return "redirect:/users";
    }


    @GetMapping("/replenishment/{id}")                        //изменение одного филда для id с редактирование на странице
    public String addMoneyForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "replenishment";
    }

    @PostMapping("/replenishment/{id}")
    public String addMoney(@PathVariable Integer id,
                           @RequestParam(value="balance") Double balance) {
        service.updateBalancePlus(balance, id);
        return "redirect:/users";

    }



}

