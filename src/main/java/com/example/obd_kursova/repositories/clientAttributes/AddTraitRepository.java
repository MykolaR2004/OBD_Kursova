package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddTraitRepository extends JpaRepository<Character, Integer> {
    @Modifying
    @Query(value = """
        INSERT INTO characters_list (User_ID, Character_ID)
        VALUES (?1, ?2);
    """, nativeQuery = true)
    void insertTrait(int userId, int traitId);
}
