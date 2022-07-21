package com.sapient.globalinsurancesbweb.controllers;


import com.sapient.globalinsurancesbweb.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class OwnerController {


    @GetMapping("/")
    public String loadHome(Model model) {
        //System.out.println("Entering home...");
        model.addAttribute("owner", new Owner());
        return "index";
    }


    @PostMapping("/owners")
    public String loginValidation(@ModelAttribute("owner") Owner owner) {

         return "success";
    }
}