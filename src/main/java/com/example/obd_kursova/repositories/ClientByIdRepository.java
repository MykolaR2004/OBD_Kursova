package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientByIdRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    total_meetings,
    most_common_country
FROM
    (SELECT
        COUNT(*) AS total_meetings,
        CNTR.Country_name AS most_common_country
    FROM
        dating_table DT
    LEFT JOIN client C1 ON DT.User_1_ID = C1.id
    LEFT JOIN client C2 ON DT.User_2_ID = C2.id
    LEFT JOIN country CNTR ON CNTR.ID = DT.Registration_country
    WHERE
        DT.User_1_ID = ?1 OR DT.User_2_ID = ?1
    GROUP BY
        CNTR.Country_name
    ORDER BY
        COUNT(*) DESC) AS subquery
ORDER BY
    total_meetings DESC
LIMIT 1;

""", nativeQuery = true)
ClientInfo getClientInfoById(int clientid);
}
