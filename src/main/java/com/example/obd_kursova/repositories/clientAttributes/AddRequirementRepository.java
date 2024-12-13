package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddRequirementRepository extends JpaRepository<Requirement, Integer> {
    @Modifying
    @Query(value = """
        INSERT INTO requirements_list (User_ID, Requirement_ID)
        VALUES (?1, ?2);
    """, nativeQuery = true)
    void insertRequirement(int userId, int requirementId);
}

