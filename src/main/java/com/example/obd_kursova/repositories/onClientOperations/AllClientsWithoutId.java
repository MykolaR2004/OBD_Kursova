package com.example.obd_kursova.repositories.onClientOperations;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AllClientsWithoutId extends JpaRepository<Client, Integer> {
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
    LEFT JOIN hobbylist HL ON HL.User_ID = C.id
    LEFT JOIN hobbies H ON HL.Hobby_ID = H.ID
    LEFT JOIN requirements_list RL ON RL.User_ID = C.id
    LEFT JOIN requirements R ON R.ID = RL.requirement_id
WHERE
    C.id <> ?1
GROUP BY
    C.id, C.name, C.surname, C.aboutYourself, C.birthdate, C.sex
ORDER BY
    C.id
""", nativeQuery = true)
    List<ClientsReqsHobbs> getClientsWithoutId(int id);

}
