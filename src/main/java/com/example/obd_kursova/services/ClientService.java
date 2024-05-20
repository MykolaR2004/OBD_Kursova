package com.example.obd_kursova.services;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.ClientIdNameSurname;
import com.example.obd_kursova.model.ClientInfo;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import com.example.obd_kursova.model.CountryList;
import com.example.obd_kursova.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientInfoRepository clientInfoRepository;
    private final ClientIdNameSurnameRepository CINSR;
    private final CountryRepository countryRepository;
    private final DateRepository dateRepository;

    public List<ClientsReqsHobbs> getClients() {
        return clientRepository.getClientsWithReqsHobbs();
    }

    public List<Client> getAllClients() {return clientRepository.findAll();}

    public ClientIdNameSurname getnameSurnameById(int id) {return CINSR.getClientNameSurname(id);}

    public List<ClientInfo> getClientInfo(int id){
        return clientInfoRepository.getClientInfo(id);
    }

    public List<CountryList> getCountries() {return countryRepository.getCountryList();}

    public void addDate(int firstid, int secondid, LocalDateTime date, int country) {
        dateRepository.getDateList(firstid, secondid, date, country);
    }
}
