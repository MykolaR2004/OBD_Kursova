package com.example.obd_kursova.repositories.chatRepositories;

import com.example.obd_kursova.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface newMessageRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
INSERT INTO chat (User_1_ID, User_2_ID, message)
VALUES (?1, ?2, ?3)
""", nativeQuery = true)
    void newMessage(int firstClientId, int secondClientId, String message);

}
