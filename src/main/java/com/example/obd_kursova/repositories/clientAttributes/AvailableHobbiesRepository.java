package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailableHobbiesRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """
        SELECT
            ID,
            Hobby
        FROM hobbies h
        WHERE NOT EXISTS (
            SELECT 1
            FROM hobbylist hl
            WHERE hl.User_ID = ?1 AND hl.Hobby_ID = h.ID
        )
    """, nativeQuery = true)
    List<Hobbies> findAvailableHobbiesByClientId(int clientId);
}

