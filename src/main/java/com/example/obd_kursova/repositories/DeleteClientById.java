package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DeleteClientById extends JpaRepository<Archive, Integer> {

    @Transactional
    @Modifying
    @Query(value = """ 
        DELETE FROM characters_list WHERE characters_list.User_ID = ?1
""", nativeQuery = true)
    void deleteClientTraitById(int clientId);

    @Transactional
    @Modifying
    @Query(value = """ 
        DELETE FROM requirements_list WHERE requirements_list.User_ID = ?1
""", nativeQuery = true)
    void deleteClientRequirementById(int clientId);

    @Transactional
    @Modifying
    @Query(value = """ 
        DELETE FROM hobbylist WHERE hobbylist.User_ID = ?1
""", nativeQuery = true)
    void deleteClientHobbyById(int clientId);

    @Transactional
    @Modifying
    @Query(value = """ 
        DELETE FROM client WHERE client.ID = ?1
""", nativeQuery = true)
    void deleteClientById(int clientId);

}


