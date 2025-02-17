package com.vehiclebase.F1.http;

import com.vehiclebase.F1.Service.UsersService;
import com.vehiclebase.F1.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetHelloController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/account")
    public String account(Model model){
        model.addAttribute("users", new Users());
        return "account";
    }

    // make the registration page more useful *add min 8 chars in password and check nick that exist already*
    @PostMapping("/account")
    public String login(@ModelAttribute Users users){
        usersService.saveDetails(users);
        return "redirect:/greeting?id_user=" + usersService.countAllUsers(); // !what if two users log in the same time! maybe change to short time variable with special number for logging user
    }

    // make more with inside side
    @GetMapping("/greeting")
    public String greeting(@RequestParam("id_user") int id_user, Model model) {
        Users logged = usersService.fetchDetails(id_user);
        if(logged != null){
            model.addAttribute("nick", logged.getNick());
        }else{
            model.addAttribute("nick", "User");
        }
        return "greeting";
    }
}