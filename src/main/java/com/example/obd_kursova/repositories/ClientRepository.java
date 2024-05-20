package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
    SELECT
    	C.*,
    	H.Hobby,
    	R.Requirement
    FROM client C, hobbies H, hobbylist HL, requirements R, requirements_list RL
    WHERE HL.`User ID` = C.id AND HL.`Hobby ID` = H.ID AND RL.User_ID = C.id AND R.ID = RL.requirement_id
    ORDER BY C.ID
""", nativeQuery = true)
    List<ClientsReqsHobbs> getClientsWithReqsHobbs();

}