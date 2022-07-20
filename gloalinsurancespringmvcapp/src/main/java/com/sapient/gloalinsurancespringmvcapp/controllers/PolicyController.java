package com.sapient.gloalinsurancespringmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PolicyController {

    @GetMapping("/")
    public String loadHome(){
        return "index";
    }

}
