package com.example.obd_kursova.repositories.chatRepositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientIdNameSurname;
import com.example.obd_kursova.model.ExistingChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface existingChat extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    chat.ID,
    chat.User_1_ID,
    CONCAT(client1.name, ' ', client1.surname) AS client1NameSurname,
    chat.User_2_ID,
    CONCAT(client2.name, ' ', client2.surname) AS client2NameSurname,
    chat.Creation_date,
    chat.Message
FROM chat
JOIN client client1 ON chat.User_1_ID = client1.id
JOIN client client2 ON chat.User_2_ID = client2.id
WHERE (chat.User_1_ID = ?1 AND chat.User_2_ID = ?2) OR (chat.User_1_ID = ?2 AND chat.User_2_ID = ?1)
ORDER BY chat.Creation_date
""", nativeQuery = true)
    List<ExistingChat> getExistingChat(int firstClientId, int secondClientId);

}
