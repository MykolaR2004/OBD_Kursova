package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Character;
import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharactersRepository extends JpaRepository<Character, Integer> {
    @Query(value = """ 
    SELECT
	    CH.ID,
	    CH.Trait
    FROM characters CH
""", nativeQuery = true)
    List<Characters> getTraitsList();

    @Override
    List<Character>
    findAllById(Iterable<Integer> ids);
}
