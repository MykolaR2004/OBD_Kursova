package com.example.obd_kursova.repositories.onClientOperations;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientById;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientByIdRepository  extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    C.id,
    C.name,
    C.surname,
    C.aboutYourself,
    TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE()) AS age,
    C.sex,
    C.birthdate,
    C.photo,
    GROUP_CONCAT(DISTINCT H.Hobby ORDER BY H.Hobby SEPARATOR ', ') AS hobby,
    GROUP_CONCAT(DISTINCT R.Requirement ORDER BY R.Requirement SEPARATOR ', ') AS requirement,
    GROUP_CONCAT(DISTINCT CH.Trait ORDER BY CH.Trait SEPARATOR ', ') AS trait
FROM
    client C
    JOIN hobbylist HL ON HL.User_ID = C.id
    JOIN hobbies H ON HL.Hobby_ID = H.ID
    JOIN requirements_list RL ON RL.User_ID = C.id
    JOIN requirements R ON R.ID = RL.requirement_id
    JOIN characters_list CL ON CL.User_ID = C.id
    JOIN characters CH ON CH.ID = CL.Character_ID
WHERE
    C.id = ?1
GROUP BY
    C.id, C.name, C.surname, C.aboutYourself, C.birthdate, C.sex, C.photo
ORDER BY
    C.id;

""", nativeQuery = true)
    ClientById getClientById(int clientid);

}
