package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeleteHobbyRepository extends JpaRepository<Hobby, Integer> {
    @Modifying
    @Query(value = """ 
        DELETE FROM hobbylist
        WHERE User_ID = ? AND Hobby_ID = ?;
""", nativeQuery = true)
    void deleteHobby(int userId, int hobbyId);
}
