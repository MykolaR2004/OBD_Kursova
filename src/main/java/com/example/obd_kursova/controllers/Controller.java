package com.example.obd_kursova.controllers;

import com.example.obd_kursova.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    private ClientService cs;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clients",cs.getClients());
        System.out.println(cs.getClients());
        return "index";
    }

    @GetMapping("/client_info")
    public String client_info(@RequestParam int id, Model model){
        model.addAttribute("clientinfo",cs.getClientInfo(id));
        System.out.println(cs.getClientInfo(id));
        return "client_info";
    }

    @PostMapping()
    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
        model.addAttribute("clientinfo",cs.getClientInfo(id));
        return "client_info";
    }
}
