package com.example.obd_kursova.repositories.archive;

import com.example.obd_kursova.data.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArchiveRepository extends JpaRepository<Archive, Integer> {
    @Query(value = """ 
    SELECT
        A.ID,
        A.date_info,
        A.Country
    FROM archive A
""", nativeQuery = true)
    List<Archive> getArchivedMeetings();

}
