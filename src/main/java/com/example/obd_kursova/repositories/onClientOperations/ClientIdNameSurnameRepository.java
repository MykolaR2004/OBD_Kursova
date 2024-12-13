package com.example.obd_kursova.repositories.onClientOperations;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientIdNameSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientIdNameSurnameRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
	C.id,
   CONCAT(C.name, ' ', C.surname) AS clientNameSurname
FROM client C
WHERE C.id = ?1
""", nativeQuery = true)
    ClientIdNameSurname getClientNameSurname(int clientid);

}
