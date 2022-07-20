package com.sapient.gloalinsurancespringmvcapp.controllers;

import com.sapient.gloalinsurancespringmvcapp.models.Policy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PolicyController {

    @GetMapping("/")
    public String loadHome(){
        return "index";
    }
    @GetMapping("/policies")
    public ModelAndView loadAddPolicy(){


        return new ModelAndView("addpolicy","policy", new Policy());
    }

    @PostMapping("policies")
    public String savePolicy(@ModelAttribute("policy") @Validated Policy policy, BindingResult result, Model model) {
        return "success";
    }
}
