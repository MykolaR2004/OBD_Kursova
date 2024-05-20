package com.example.obd_kursova.controllers;

import com.example.obd_kursova.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;


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
//        Optional<Client> a = cs.getAllClients();
        model.addAttribute("clientinfo",cs.getClientInfo(id));
        model.addAttribute("id",id);
        model.addAttribute("client",cs.getnameSurnameById(id));
        model.addAttribute("countrylist", cs.getCountries());
        model.addAttribute("clients",cs.getClients());
        return "client_info";
    }

    @PostMapping("/add_date")
    public String add_date(@RequestParam int firstid, int secondid, LocalDateTime date, int country, Model model){
        cs.addDate(firstid, secondid, date, country);
        return "index";
    }
}
