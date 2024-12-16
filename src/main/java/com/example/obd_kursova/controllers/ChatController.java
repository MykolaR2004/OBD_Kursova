package com.example.obd_kursova.controllers;

import com.example.obd_kursova.services.ChatService;
import com.example.obd_kursova.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class ChatController {
    private ChatService chat;
    private MainService mainService;

    @GetMapping("/chat_page")
    public String chatClient(@RequestParam int id, Model model){
        model.addAttribute("client", mainService.getNameSurnameById(id));
        model.addAttribute("availableClients", chat.getClientsForNewChat(id));
        model.addAttribute("activeChats", chat.getActiveChats(id));
        return "chat_page";
    }

    @GetMapping("/open_chat")
    public String open_chat(@RequestParam int firstClientId, @RequestParam int secondClientId, Model model){
        model.addAttribute("messages", chat.openChat(firstClientId, secondClientId));
        model.addAttribute("currentUserId", firstClientId);
        model.addAttribute("secondClientId", secondClientId);
        return "chat_view";
    }



    @PostMapping("/send_message")
    public String send_message(@RequestParam int firstid, int secondid,String message) {
        chat.sendMessage(firstid, secondid, message);
        return "redirect:/open_chat?firstClientId=" + firstid + "&secondClientId=" + secondid;
    }

    @PostMapping("/delete_message")
    public String delete_message(@RequestParam int firstid, int secondid, int messageId) {
        chat.deleteMessage(messageId);
        return "redirect:/open_chat?firstClientId=" + firstid + "&secondClientId=" + secondid;
    }
}
