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

    @PostMapping("/account")
    public Users login(@RequestBody Users users){ return usersService.saveDetails(users);}

    @GetMapping("/account")
    public String account(){
        return "account";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "nick", required = false, defaultValue = "Adam") String nick, Model model) {
        model.addAttribute("nick", nick);
        return "greeting";
    }

//    @GetMapping("/templates/driver_start")
//    public String driverStart(Model model){
//        return "/templates/driver_start";
//    }
}