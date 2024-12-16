package com.example.obd_kursova.controllers;

import com.example.obd_kursova.model.MeetingsPerCountryPerYear;
import com.example.obd_kursova.services.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class StatisticsController {
    private MainService mainService;


    @GetMapping("/country_statistics")
    public String countryStat(Model model){
        model.addAttribute("countrylist", mainService.getCountries());
        return "country_statistics";
    }

    @PostMapping("/country_statistics")
    public String countryStat(@RequestParam int year, @RequestParam String country, Model model){
        model.addAttribute("countrylist", mainService.getCountries());
        model.addAttribute("year", year);
        model.addAttribute("selectedCountry", country);
        List<MeetingsPerCountryPerYear> countryStats = mainService.getMeetingsPerCountry(year, country);
        model.addAttribute("countryStat", countryStats);

        List<String> months = countryStats.stream().map(MeetingsPerCountryPerYear::getMonth).collect(Collectors.toList());
        List<Integer> totalMeetings = countryStats.stream().map(MeetingsPerCountryPerYear::getTotalMeetings).collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String monthsJson = objectMapper.writeValueAsString(months);
            String totalMeetingsJson = objectMapper.writeValueAsString(totalMeetings);
            model.addAttribute("monthsJson", monthsJson);
            model.addAttribute("totalMeetingsJson", totalMeetingsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "country_statistics";
    }
}
