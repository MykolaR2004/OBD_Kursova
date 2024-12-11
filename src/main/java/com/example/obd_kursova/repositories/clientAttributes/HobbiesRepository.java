package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbiesRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """ 
    SELECT
	    H.ID,
	    H.Hobby
    FROM hobbies H
""", nativeQuery = true)
    List<Hobbies> getHobbyList();


    @Override
    List<Hobby>
    findAllById(Iterable<Integer> ids);
}
