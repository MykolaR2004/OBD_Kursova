package com.example.obd_kursova.repositories;

import com.example.obd_kursova.data.Country;
import com.example.obd_kursova.model.CountryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = """ 
            SELECT
               C.ID,
               C.Country_name
              FROM country C
""", nativeQuery = true)
    List<CountryList> getCountryList();

}
