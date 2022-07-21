package com.sapient.globalinsurancesbweb.controllers;


import com.google.gson.Gson;
import com.sapient.globalinsurancesbweb.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller

public class OwnerController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url}")
    private String url;


    @GetMapping("/")
    public String loadHome(Model model) {
        //System.out.println("Entering home...");
        model.addAttribute("owner", new Owner());
        return "index";
    }


    @PostMapping("/owners")
    public String addOwner(@ModelAttribute("owner") Owner owner, Model model) {
        Gson   gson=new Gson();

        if(owner.getMobileNo()>0) {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request = new HttpEntity<>(owner,headers);


            ResponseEntity<?> authResponse=restTemplate.
                    postForEntity(url+"/owners/v1.0",request, String.class);

            Owner owner1 = gson.fromJson(authResponse.getBody().toString(), Owner.class);
            model.addAttribute("owner", owner1);
                return "success";


        }
        else

          return "redirect:/";

    }


}