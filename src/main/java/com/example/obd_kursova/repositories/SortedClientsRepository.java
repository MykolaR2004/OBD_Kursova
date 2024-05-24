package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SortedClientsRepository extends JpaRepository<Client, Integer>{
    @Query(value = """
    SELECT
        C.*,
        H.Hobby,
        R.Requirement
    FROM 
        client C, hobbies H, hobbylist HL, requirements R, requirements_list RL
    WHERE 
        HL.`User ID` = C.id 
        AND HL.`Hobby ID` = H.ID 
        AND RL.User_ID = C.id 
        AND R.ID = RL.requirement_id
    ORDER BY
    CASE ?1
        WHEN 'id' THEN CAST(C.id AS SIGNED)
        WHEN 'name' THEN C.name
        WHEN 'surname' THEN C.surname
        WHEN 'aboutYourself' THEN C.aboutYourself
        WHEN 'age' THEN C.age
        WHEN 'birthdate' THEN C.birthdate
        WHEN 'hobby' THEN H.Hobby

    END
""", nativeQuery = true)

    List<ClientsReqsHobbs> getClientsWithReqsHobbsSortedByName(String sortBy);
}



