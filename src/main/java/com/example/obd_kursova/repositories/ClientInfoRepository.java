package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientInfo;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientInfoRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
	DT.id,
	CONCAT(C1.name, ' ', C1.surname) AS client1,
	CONCAT(C2.name, ' ', C2.surname) AS client2,
	DT.Date,
	CNTR.`Country name` AS `Country`
FROM dating_table DT
LEFT JOIN client C1 ON DT.User_1_ID = C1.id
LEFT JOIN client C2 ON DT.User_2_ID = C2.id
LEFT JOIN country CNTR ON CNTR.ID = DT.Registration_country
WHERE DT.User_1_ID = ?1 OR DT.User_2_ID = ?1
""", nativeQuery = true)
    List<ClientInfo> getClientInfo(int clientid);

}