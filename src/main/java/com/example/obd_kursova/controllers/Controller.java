package com.example.obd_kursova.controllers;

import com.example.obd_kursova.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    private ClientService cs;



    @GetMapping("/")
    public String getClients(Model model) {
        model.addAttribute("clients", cs.getClients());
        model.addAttribute("hobbies", cs.getHobbies());
        model.addAttribute("requirements", cs.getHobbies());
        return "index";
    }

    @GetMapping("/dates_info")
    public String dates_info(@RequestParam int id, Model model){
        model.addAttribute("clientinfo",cs.getDateInfo(id));
        model.addAttribute("id",id);
        model.addAttribute("client",cs.getnameSurnameById(id));
        model.addAttribute("countrylist", cs.getCountries());
        model.addAttribute("clients",cs.getClients());
        return "dates_info";
    }

    @GetMapping("/client_info")
    public String client_info(@RequestParam int id, Model model){
        model.addAttribute("client", cs.getClientInfo(id));
        return "client_info";
    }

    @PostMapping("/add_date")
    public String add_date(@RequestParam int firstid, int secondid, LocalDateTime date, int country, Model model){
        cs.addDate(firstid, secondid, date, country);
        return "redirect:/client_info?id=" + firstid;
    }

    @PostMapping("/add_client")
    public String addClient(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String aboutYourself,
                            @RequestParam int age,
                            @RequestParam String sex,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                            @RequestParam int hobby,
                            @RequestParam int requirement,
                            Model model) {
        cs.addClient(firstName, lastName, aboutYourself, age, sex, birthdate, hobby, requirement);
        return "redirect:/";
    }

    @GetMapping("/sortedClients")
    public String getSortedClients(@RequestParam(required = false) String sort, Model model) {
        if (sort != null) {
            model.addAttribute("clients", cs.getSortedClients(sort));
        }
        if (Objects.equals(sort, "id")){
            return getClients(model);
        }
        return "index";
    }



}
