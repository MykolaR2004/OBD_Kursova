package com.example.obd_kursova.repositories.dates;

import com.example.obd_kursova.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface UpdateDateRepository extends JpaRepository<DatingTable, Integer> {
    @Transactional
    @Modifying
    @Query(value = """ 
        UPDATE `dating_table` SET `Date` = ? WHERE `id` = ?;
""", nativeQuery = true)
    void updateDate(LocalDateTime date, int dateId);
}
