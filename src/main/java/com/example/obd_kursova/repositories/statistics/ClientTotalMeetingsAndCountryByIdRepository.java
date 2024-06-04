package com.example.obd_kursova.repositories.statistics;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientTotalMeetingsAndCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientTotalMeetingsAndCountryByIdRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
            COUNT(*) AS totalMeetings,
            CNTR.Country_name AS mostCommonCountry
        FROM
            dating_table DT
        JOIN
            country CNTR ON CNTR.ID = DT.Registration_country
        WHERE
            DT.User_1_ID = ?1 OR DT.User_2_ID = ?1

""", nativeQuery = true)
    ClientTotalMeetingsAndCountry getClientInfoById(int clientid);
}
