package com.example.obd_kursova.repositories.dates;

import com.example.obd_kursova.data.DatingTable;
import com.example.obd_kursova.model.DatesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FindDateByIdDateRepository extends JpaRepository<DatingTable, Integer> {

  @Query(value = """ 
SELECT
    DT.id,
    CONCAT(C1.name, ' ', C1.surname) AS client1,
    C1.id AS client1_id,
    CONCAT(C2.name, ' ', C2.surname) AS client2,
    C2.id AS client2_id,
    DT.Date,
    CNTR.Country_name AS Country
FROM dating_table DT
LEFT JOIN client C1 ON DT.User_1_ID = C1.id
LEFT JOIN client C2 ON DT.User_2_ID = C2.id
LEFT JOIN country CNTR ON CNTR.ID = DT.Registration_country
WHERE DT.ID = ?;
""", nativeQuery = true)
  DatesInfo findDateById(int dateId);
}