package com.example.obd_kursova.controllers;

import com.example.obd_kursova.services.ChatService;
import com.example.obd_kursova.services.ClientOperationsService;
import com.example.obd_kursova.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class DatesController {
    private MainService mainService;

    @GetMapping("/dates_info")
    public String datesInfo(@RequestParam int id, Model model){
        model.addAttribute("clientinfo", mainService.getDateInfo(id));
        model.addAttribute("id",id);
        model.addAttribute("client", mainService.getNameSurnameById(id));
        model.addAttribute("countrylist", mainService.getCountries());
        model.addAttribute("clients", mainService.getAllOtherClients(id));
        return "dates_info";
    }

    @GetMapping("/edit_date")
    public String editDate(@RequestParam int date_id, int client_id, Model model) {
        model.addAttribute("dateInfo", mainService.getDateByIdInfo(date_id));
        model.addAttribute("client",mainService.getNameSurnameById(client_id));
        return "edit_date";
    }

    @PostMapping("/update_date")
    public String updateDate(@RequestParam int date_id, int client_id,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        mainService.updateDate(date_id, date);
        return "redirect:/dates_info?id=" + client_id;
    }

    @GetMapping("/archived_meetings")
    public String archivedMeetings(Model model){
        model.addAttribute("archive", mainService.getArchivedMeetings());
        return "archived_meetings";
    }

    @PostMapping("/add_date")
    public String add_date(@RequestParam int firstid, int secondid, LocalDateTime date, int country){
        mainService.addDate(firstid, secondid, date, country);
        return "redirect:/dates_info?id=" + firstid;
    }

    @PostMapping("/archive_date")
    public String archive_date(@RequestParam int date_id, int client_id){
        mainService.archiveDate(date_id);
        System.out.println("DATE COPIED?");
        return "redirect:/dates_info?id=" + client_id;
    }
}
