package com.example.obd_kursova.repositories.chatRepositories;

import com.example.obd_kursova.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface deleteMessageRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
DELETE FROM chat WHERE  `ID`=?1
""", nativeQuery = true)
    void deleteMessage(int messageId);

}
