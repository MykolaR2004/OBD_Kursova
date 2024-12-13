package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeleteTraitRepository extends JpaRepository<Character, Integer> {
    @Modifying
    @Query(value = """
        DELETE FROM characters_list
        WHERE User_ID = ? AND Character_ID = ?;
    """, nativeQuery = true)
    void deleteTrait(int userId, int traitId);
}
