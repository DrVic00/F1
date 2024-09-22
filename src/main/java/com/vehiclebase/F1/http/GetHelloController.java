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

    @PostMapping("/account")
    public String login(@ModelAttribute Users users){
        usersService.saveDetails(users);
        usersService.fetchDetails(users.getId_user());
        return "added_user";
    }

    @GetMapping("/greeting{id_user}")
    public String greeting(@RequestParam(value = "nick", required = false, defaultValue = "Adam") String nick, Model model) {
        model.addAttribute("nick", nick);
        return "greeting";
    }

    //    @GetMapping("/greeting/{id_user}") // do naprawy
//    public String greeting(@PathVariable int id_user, Model model) {
//        model.addAttribute("nick", Integer.toString(id_user));
//        usersService.fetchDetails(id_user);
//        return "greeting";
//    }
}