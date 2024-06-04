package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface UpdateClientRepository extends JpaRepository<Client, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE client SET name = ?2, surname = ?3, aboutYourself = ?4, age = ?5, sex = ?6, birthdate = ?7 WHERE id = ?1", nativeQuery = true)
    void updateClient(int id, String firstName, String lastName, String aboutYourself, int age, String sex, LocalDate birthdate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hobbylist SET Hobby_ID = ?2 WHERE User_ID = ?1", nativeQuery = true)
    void updateHobby(int userId, int hobbyId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE requirements_list SET requirement_id = ?2 WHERE User_ID = ?1", nativeQuery = true)
    void updateRequirement(int userId, int requirementId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE characters_list SET Character_ID = ?2 WHERE User_ID = ?1", nativeQuery = true)
    void updateTrait(int userId, int traitId);
}


