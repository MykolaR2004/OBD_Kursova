package com.example.obd_kursova.repositories.dates;

import com.example.obd_kursova.data.Archive;
import com.example.obd_kursova.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ArchiveDateByIdRepository extends JpaRepository<Archive, Integer> {

    @Modifying
    @Transactional
    @Query(value = """ 

            INSERT INTO `meeting_agency`.archive (`Date_info`, `Country`)
VALUES (
    (
        SELECT
            CONCAT(
                C1.name, ' ', C1.surname, ', ',
                C2.name, ' ', C2.surname, ', ',
                DATE_FORMAT(DT.Date, '%Y-%m-%d')
            ) AS Date_info
        FROM dating_table DT
        JOIN client C1 ON DT.User_1_ID = C1.id
        JOIN client C2 ON DT.User_2_ID = C2.id
        WHERE DT.ID = ?1
    ),\s
    (
        SELECT
            CNTR.Country_name AS Country
        FROM dating_table DT
        JOIN country CNTR ON CNTR.ID = DT.Registration_country
        WHERE DT.ID = ?1
    )
)
""", nativeQuery = true)
    void addDateToArchive(int dateId);

    @Modifying
    @Query(value = """ 
        DELETE FROM meeting_agency.dating_table WHERE  dating_table.ID = ?1
""", nativeQuery = true)
    void removeDateFromTable(int dateId);

}
