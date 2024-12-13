package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Character;
import com.example.obd_kursova.data.Requirement;
import com.example.obd_kursova.model.Characters;
import com.example.obd_kursova.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailableTraitsRepository extends JpaRepository<Character, Integer> {
    @Query(value = """
        SELECT t.*
        FROM characters t
        WHERE NOT EXISTS (
            SELECT 1
            FROM characters_list tl
            WHERE tl.User_ID = ?1 AND tl.Character_ID = t.ID
        )
    """, nativeQuery = true)
    List<Characters> findAvailableTraitsByClientId(int clientId);
}



