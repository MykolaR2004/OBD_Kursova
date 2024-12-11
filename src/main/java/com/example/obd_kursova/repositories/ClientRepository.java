package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    C.id,
    C.name,
    C.surname,
    C.aboutYourself,
    TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE()) AS age,
    C.sex,
    C.birthdate,
    GROUP_CONCAT(DISTINCT H.Hobby ORDER BY H.Hobby SEPARATOR ', ') AS hobby,
    GROUP_CONCAT(DISTINCT R.Requirement ORDER BY R.Requirement SEPARATOR ', ') AS requirement
FROM
    client C
    JOIN hobbylist HL ON HL.User_ID = C.id
    JOIN hobbies H ON HL.Hobby_ID = H.ID
    JOIN requirements_list RL ON RL.User_ID = C.id
    JOIN requirements R ON R.ID = RL.requirement_id
GROUP BY
    C.id, C.name, C.surname, C.aboutYourself, C.birthdate, C.sex, R.Requirement
ORDER BY
    C.ID
""", nativeQuery = true)
    List<ClientsReqsHobbs> getClientsWithReqsHobbs();

}

