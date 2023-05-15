package com.example.SiteRestaurant.controller;

import com.example.SiteRestaurant.entities.Client;
import com.example.SiteRestaurant.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new Client());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Client person, Errors errors){
        if(errors.hasErrors())
            return "register";
        boolean isSaved = clientService.createNewPerson(person);
        if(isSaved)
            return "redirect:/login?register=true";
        else
            return "register";
    }
}
