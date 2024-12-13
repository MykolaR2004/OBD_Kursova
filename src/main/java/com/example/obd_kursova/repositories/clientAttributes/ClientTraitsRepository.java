package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Character;
import com.example.obd_kursova.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientTraitsRepository extends JpaRepository<Character, Integer> {
  @Query(value = """
        SELECT t.*
        FROM characters t
        JOIN characters_list tl ON tl.Character_ID = t.ID
        WHERE tl.User_ID = ?1
    """, nativeQuery = true)
  List<Characters> findTraitsByClientId(int clientId);
}