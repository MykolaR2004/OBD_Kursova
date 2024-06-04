package com.example.obd_kursova.services;

import com.example.obd_kursova.model.ClientIdNameSurname;
import com.example.obd_kursova.model.ExistingChat;
import com.example.obd_kursova.repositories.chatRepositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private final clientsForNewChatRepository clientsForNewChat;
    private final activeChatsRepository activeChats;
    private final existingChat existingChat;
    private final newMessageRepository newMessageRepository;
    private final deleteMessageRepository deleteMessage;

    public List<ClientIdNameSurname> getClientsForNewChat(int id) {
        return clientsForNewChat.getAllClientNameSurname(id);
    }

    public List<ClientIdNameSurname> getActiveChats(int id) {
        return activeChats.getAllActiveChatsClientNameSurname(id);
    }

    public List<ExistingChat> openChat(int firstClientId, int secondClientId) {
        return existingChat.getExistingChat(firstClientId,secondClientId);
    }

    public void sendMessage(int firstClientId, int secondClientId, String message) {
        newMessageRepository.newMessage(firstClientId, secondClientId, message);
    }

    public void deleteMessage(int messageId) {
        deleteMessage.deleteMessage(messageId);
    }
}
