package com.example.obd_kursova.services;

import com.example.obd_kursova.data.Client;
import com.example.obd_kursova.model.*;
import com.example.obd_kursova.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDateInfoRepository clientDateInfoRepository;
    private final ClientIdNameSurnameRepository CINSR;
    private final CountryRepository countryRepository;
    private final DateRepository dateRepository;
    private final HobbiesRepository hobbiesRepository;
    private final NewClientRepository newClientRepository;
    private final SortedClientsRepository sortedClientsRepository;
    private final ClientByIdRepository clientByIdRepository;

    public List<ClientsReqsHobbs> getClients() {
        return clientRepository.getClientsWithReqsHobbs();
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public List<Hobbies> getHobbies() {
        return hobbiesRepository.getHobbyList();
    }

    public ClientIdNameSurname getnameSurnameById(int id) {return CINSR.getClientNameSurname(id);}

    public List<DatesInfo> getDateInfo(int id){
        return clientDateInfoRepository.getDateInfo(id);
    }

    public ClientInfo getClientInfo(int id){
        return clientByIdRepository.getClientInfoById(id);
    }

    public List<CountryList> getCountries() {return countryRepository.getCountryList();}

    public void addDate(int firstid, int secondid, LocalDateTime date, int country) {
        dateRepository.getDateList(firstid, secondid, date, country);
    }

    @Transactional
    public void addClient(String firstName, String lastName, String aboutYourself, int age, String sex, LocalDate birthdate, int hobbyId, int requirementId) {
        newClientRepository.insertClient(firstName, lastName, aboutYourself, age, sex, birthdate);
        Integer clientId = newClientRepository.getLastInsertId();
        newClientRepository.insertHobby(clientId, hobbyId);
        newClientRepository.insertRequirement(clientId, requirementId);
    }

    public List<ClientsReqsHobbs> getSortedClients(String sortBy) {
        return sortedClientsRepository.getClientsWithReqsHobbsSortedByName(sortBy);
    }
}
