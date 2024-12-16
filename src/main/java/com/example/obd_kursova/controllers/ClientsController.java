package com.example.obd_kursova.controllers;

import com.example.obd_kursova.model.ClientMostPopularCountries;
import com.example.obd_kursova.services.ClientOperationsService;
import com.example.obd_kursova.services.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class ClientsController {

    private MainService mainService;
    private ClientOperationsService clientOperations;



    @GetMapping("/")
    public String getClients(Model model) {
        model.addAttribute("clients", mainService.getClients());
        model.addAttribute("hobbies", mainService.getHobbies());
        model.addAttribute("requirements", mainService.getRequirements());
        model.addAttribute("characters", mainService.getCharacters());
        return "index";
    }


    @GetMapping("/client_info")
    public String clientInfo(@RequestParam int id, Model model) {
        model.addAttribute("clientStatistics", mainService.getClientTotalMeetingsAndCountryInfo(id));
        model.addAttribute("clientInfo", mainService.getClientById(id));
        model.addAttribute("clientPopularCountries", mainService.getClientPopularCountries(id));

        List<ClientMostPopularCountries> popularCountries = mainService.getClientPopularCountries(id);
        int totalMeetings = mainService.getClientTotalMeetings(id).getTotalMeetings();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String countriesJson = objectMapper.writeValueAsString(
                    popularCountries.stream().map(ClientMostPopularCountries::getMostCommonCountry).collect(Collectors.toList())
            );
            String meetingsJson = objectMapper.writeValueAsString(
                    popularCountries.stream().map(ClientMostPopularCountries::getTotalMeetings).collect(Collectors.toList())
            );
            model.addAttribute("countriesJson", countriesJson);
            model.addAttribute("meetingsJson", meetingsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("totalMeetings", totalMeetings);

        return "client_info";
    }



    @GetMapping("/update_client")
    public String updateClient(@RequestParam int id, Model model) {
        model.addAttribute("clientInfo", mainService.getClientById(id));
        model.addAttribute("clientHobbies", mainService.getClientHobbies(id));
        model.addAttribute("clientRequirements", mainService.getClientRequirements(id));
        model.addAttribute("clientTraits", mainService.getClientTraits(id));
        model.addAttribute("clientAvailableHobbies", clientOperations.getAvailableHobbies(id));
        model.addAttribute("clientAvailableRequirements", clientOperations.getAvailableRequirements(id));
        model.addAttribute("clientAvailableTraits", clientOperations.getAvailableCharacters(id));
        model.addAttribute("hobbies", mainService.getHobbies());
        model.addAttribute("requirements", mainService.getRequirements());
        model.addAttribute("characters", mainService.getCharacters());
        return "update_client";
    }


    @PostMapping("/add_hobby")
    public String addHobby(@RequestParam int clientId, @RequestParam int hobbyId) {
        clientOperations.addHobbyToClient(clientId, hobbyId);
        return "redirect:/update_client?id=" + clientId;
    }

    @PostMapping("/delete_hobby")
    public String deleteHobby(@RequestParam int clientId, @RequestParam int hobbyId) {
        clientOperations.removeHobbyFromClient(clientId, hobbyId);
        return "redirect:/update_client?id=" + clientId;
    }

    @PostMapping("/add_requirement")
    public String addRequirement(@RequestParam int clientId, @RequestParam int requirementId) {
        clientOperations.addRequirementToClient(clientId, requirementId);
        return "redirect:/update_client?id=" + clientId;
    }

    @PostMapping("/delete_requirement")
    public String deleteRequirement(@RequestParam int clientId, @RequestParam int requirementId) {
        clientOperations.removeRequirementFromClient(clientId, requirementId);
        return "redirect:/update_client?id=" + clientId;
    }

    @PostMapping("/add_trait")
    public String addTrait(@RequestParam int clientId, @RequestParam int traitId) {
        clientOperations.addTraitToClient(clientId, traitId);
        return "redirect:/update_client?id=" + clientId;
    }

    @PostMapping("/delete_trait")
    public String deleteTrait(@RequestParam int clientId, @RequestParam int traitId) {
        clientOperations.removeTraitFromClient(clientId, traitId);
        return "redirect:/update_client?id=" + clientId;
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
                            @RequestParam int trait) {
        clientOperations.addClient(firstName, lastName, aboutYourself, age, sex, birthdate, hobby, requirement, trait);
        return "redirect:/";
    }

    @PostMapping("/update_client")
    public String updateClient(@RequestParam int id,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String aboutYourself,
                               @RequestParam int age,
                               @RequestParam String sex,
                               @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate) {
        mainService.updateClient(id, firstName, lastName, aboutYourself, age, sex, birthdate);
        return "redirect:/client_info?id=" + id;
    }


    @PostMapping("/delete_client")
    public String deleteClient(@RequestParam int id) {
        mainService.deleteClient(id);
        return "redirect:/";
    }



    @GetMapping("/sortedClients")
    public String getSortedClients(@RequestParam(required = false) String sort, Model model) {
        if (sort != null) {
            model.addAttribute("clients", mainService.getSortedClients(sort));
            model.addAttribute("hobbies", mainService.getHobbies());
            model.addAttribute("requirements", mainService.getRequirements());
            model.addAttribute("characters", mainService.getCharacters());
        }
        if (Objects.equals(sort, "id")){
            return getClients(model);
        }
        return "index";
    }

}
