package com.example.obd_kursova.repositories.chatRepositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientIdNameSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface activeChatsRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    C.id,
    CONCAT(C.name, ' ', C.surname) AS clientNameSurname
FROM client C
WHERE C.id IN (
    SELECT User_1_ID FROM chat WHERE User_2_ID = ?1
    UNION ALL
    SELECT User_2_ID FROM chat WHERE User_1_ID = ?1
)
""", nativeQuery = true)
    List<ClientIdNameSurname> getAllActiveChatsClientNameSurname(int clientid);

}
