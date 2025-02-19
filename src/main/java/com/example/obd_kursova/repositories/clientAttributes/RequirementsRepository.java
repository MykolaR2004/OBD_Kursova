package com.example.obd_kursova.repositories.clientAttributes;

import com.example.obd_kursova.data.Requirement;
import com.example.obd_kursova.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequirementsRepository extends JpaRepository<Requirement, Integer> {
    @Query(value = """ 
    SELECT
	    R.ID,
	    R.requirement
    FROM requirements R
""", nativeQuery = true)
    List<Requirements> getRequirementsList();
}
