package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeleteRequirementRepository extends JpaRepository<Requirement, Integer> {
  @Modifying
  @Query(value = """
        DELETE FROM requirements_list
        WHERE User_ID = ? AND Requirement_ID = ?;
    """, nativeQuery = true)

  void deleteRequirement(int userId, int requirementId);
}
