package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientHobbiesRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """
        SELECT h.*
        FROM hobbies h
        JOIN hobbylist hl ON hl.Hobby_ID = h.ID
        WHERE hl.User_ID = ?1
    """, nativeQuery = true)
    List<Hobbies> findHobbiesByClientId(int clientId);
}