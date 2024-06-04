package com.example.obd_kursova.repositories.statistics;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.MeetingsPerCountryPerYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingsByCountryPerYear extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
    DATE_FORMAT(DT.`Date`, '%Y-%m') AS month,
    COUNT(*) AS totalMeetings,
    CNTR.Country_name AS country
FROM
    dating_table DT
LEFT JOIN
    country CNTR ON CNTR.ID = DT.Registration_country
WHERE
    YEAR(DT.`Date`) = ?1
    AND CNTR.Country_name = ?2
GROUP BY
    DATE_FORMAT(DT.`Date`, '%Y-%m'), CNTR.Country_name
ORDER BY
    month
""", nativeQuery = true)
    List<MeetingsPerCountryPerYear> getMeetingsForCountryPerYear(int year, String country);
}
