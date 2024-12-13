package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddHobbyRepository extends JpaRepository<Hobby, Integer> {
    @Modifying
    @Query(value = """ 
        INSERT INTO hobbylist (User_ID, Hobby_ID)
        VALUES (?1, ?2);
""", nativeQuery = true)
    void insertHobby(int userId, int hobbyId);
}