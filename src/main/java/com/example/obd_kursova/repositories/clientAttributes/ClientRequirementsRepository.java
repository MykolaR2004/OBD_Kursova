package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Requirement;
import com.example.obd_kursova.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRequirementsRepository extends JpaRepository<Requirement, Integer> {
    @Query(value = """
        SELECT r.*
        FROM requirements r
        JOIN requirements_list rl ON rl.Requirement_ID = r.ID
        WHERE rl.User_ID = ?1
    """, nativeQuery = true)
    List<Requirements> findRequirementsByClientId(int clientId);
}