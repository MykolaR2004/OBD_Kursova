package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Hobby;
import com.example.obd_kursova.data.Requirement;
import com.example.obd_kursova.model.Characters;
import com.example.obd_kursova.model.Hobbies;
import com.example.obd_kursova.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailableRequirementsRepository extends JpaRepository<Requirement, Integer> {
    @Query(value = """
        SELECT
            ID,
            requirement
        FROM requirements r
        WHERE NOT EXISTS (
            SELECT 1
            FROM requirements_list rl
            WHERE rl.User_ID = ?1 AND rl.Requirement_ID = r.ID
        )
    """, nativeQuery = true)
    List<Requirements> findAvailableRequirementsByClientId(int clientId);
}


