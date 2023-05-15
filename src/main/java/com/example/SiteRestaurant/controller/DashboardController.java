package com.example.SiteRestaurant.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String displayHome(Model model, Authentication authetication){
        model.addAttribute("username", authetication.getName());
        model.addAttribute("roles", authetication.getAuthorities().toString());
        return "dashboard.html";
    }
}
