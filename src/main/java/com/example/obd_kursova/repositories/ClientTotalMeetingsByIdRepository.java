package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientTotalMeetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientTotalMeetingsByIdRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
            COUNT(*) AS totalMeetings
        FROM
            dating_table DT
        WHERE
            DT.User_1_ID = ?1 OR DT.User_2_ID = ?1
""", nativeQuery = true)
    ClientTotalMeetings getClientTotalMeetingsById(int clientid);
}
