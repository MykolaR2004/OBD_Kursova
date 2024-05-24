package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface NewClientRepository extends JpaRepository<Client, Integer> {

    @Modifying
    @Query(value = "INSERT INTO client (name, surname, aboutYourself, age, sex, birthdate) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertClient(String firstName, String lastName, String aboutYourself, int age, String sex, LocalDate birthdate);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Integer getLastInsertId();

    @Modifying
    @Query(value = "INSERT INTO hobbylist (`User ID`, `Hobby ID`) VALUES (?1, ?2)", nativeQuery = true)
    void insertHobby(int userId, int hobbyId);

    @Modifying
    @Query(value = "INSERT INTO requirements_list (User_ID, requirement_id) VALUES (?1, ?2)", nativeQuery = true)
    void insertRequirement(int userId, int requirementId);
}

