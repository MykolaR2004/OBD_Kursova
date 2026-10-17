package com.example.obd_kursova.repositories.onClientOperations;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SortedClientsRepository extends JpaRepository<Client, Integer>{
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
GROUP BY
    C.id, C.name, C.surname, C.aboutYourself, C.birthdate, C.sex
ORDER BY
    CASE WHEN ?1 = 'name' THEN C.name END,
    CASE WHEN ?1 = 'surname' THEN C.surname END,
    CASE WHEN ?1 = 'aboutYourself' THEN C.aboutYourself END,
    CASE WHEN ?1 = 'age' THEN TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE()) END,
    CASE WHEN ?1 = 'sex' THEN C.sex END,
    CASE WHEN ?1 = 'birthdate' THEN C.birthdate END,
    CASE WHEN ?1 = 'hobby' THEN hobby END,
    CASE WHEN ?1 = 'requirement' THEN requirement END,
    C.id
""", nativeQuery = true)

    List<ClientsReqsHobbs> getClientsWithReqsHobbsSortedByName(String sortBy);
}



