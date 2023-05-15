package com.example.SiteRestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
@Controller
public class DemoController {
    @GetMapping(value = {"/", "","/home"})
    public String home(){
        return "index.html";
    }

    @GetMapping(value="/dataBase")
    public String toDatabase(){
        return "database.html";
    }


}
