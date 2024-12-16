package com.example.obd_kursova.services;

import com.example.obd_kursova.data.Archive;
import com.example.obd_kursova.model.*;
import com.example.obd_kursova.repositories.*;
import com.example.obd_kursova.repositories.archive.ArchiveRepository;
import com.example.obd_kursova.repositories.clientAttributes.*;
import com.example.obd_kursova.repositories.dates.*;
import com.example.obd_kursova.repositories.onClientOperations.*;
import com.example.obd_kursova.repositories.statistics.ClientPopularCountriesRepository;
import com.example.obd_kursova.repositories.statistics.ClientTotalMeetingsAndCountryByIdRepository;
import com.example.obd_kursova.repositories.statistics.MeetingsByCountryPerYear;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MainService {

    private final ClientRepository clientRepository;
    private final ClientDateInfoRepository clientDateInfoRepository;
    private final ClientIdNameSurnameRepository CINSR;
    private final ClientByIdRepository clientByIdRepository;
    private final AllClientsWithoutId clientsWithoutId;
    private final CountryRepository countryRepository;

    private final FindDateByIdDateRepository findDateByIdDateRepository;
    private final UpdateDateRepository updateDateRepository;
    private final NewDateRepository newDateRepository;
    private final ArchiveDateByIdRepository archiveDateByIdRepository;

    private final HobbiesRepository hobbiesRepository;
    private final RequirementsRepository requirementsRepository;
    private final CharactersRepository charactersRepository;

    private final UpdateClientRepository updateClientRepository;
    private final SortedClientsRepository sortedClientsRepository;
    private final ClientTotalMeetingsAndCountryByIdRepository clientTotalMeetingsAndCountryByIdRepository;
    private final ClientTotalMeetingsByIdRepository clientTotalMeetingsByIdRepository;
    private final MeetingsByCountryPerYear meetingsByCountryPerYear;
    private final ClientPopularCountriesRepository cpcr;
    private final ArchiveRepository archiveRepository;
    private final DeleteClientById deleteClientById;
    private final ClientHobbiesRepository clientHobbiesRepository;
    private final ClientRequirementsRepository clientRequirementsRepository;
    private final ClientTraitsRepository clientTraitsRepository;



    public List<ClientsReqsHobbs> getClients() {
        return clientRepository.getClientsWithReqsHobbs();
    }

    public List<ClientsReqsHobbs> getAllOtherClients(int id) {
        return clientsWithoutId.getClientsWithoutId(id);
    }

    public List<Hobbies> getHobbies() {
        return hobbiesRepository.getHobbyList();
    }

    public List<Requirements> getRequirements() {
        return requirementsRepository.getRequirementsList();
    }

    public List<Characters> getCharacters() {
        return charactersRepository.getTraitsList();
    }

    public ClientById getClientById(int id){
        return clientByIdRepository.getClientById(id);
    }

    public ClientIdNameSurname getNameSurnameById(int id) {return CINSR.getClientNameSurname(id);}

    public List<DatesInfo> getDateInfo(int id){
        return clientDateInfoRepository.getDateInfo(id);
    }

    public ClientTotalMeetingsAndCountry getClientTotalMeetingsAndCountryInfo(int id){
        return clientTotalMeetingsAndCountryByIdRepository.getClientInfoById(id);
    }

    public List<ClientMostPopularCountries> getClientPopularCountries(int id){
        return cpcr.getClientPopularCountriesById(id);
    }

    public List<MeetingsPerCountryPerYear> getMeetingsPerCountry(int id, String country){
        return meetingsByCountryPerYear.getMeetingsForCountryPerYear(id, country);
    }

    public List<CountryList> getCountries() {return countryRepository.getCountryList();}

    @Transactional
    public void addDate(int firstid, int secondid, LocalDateTime date, int country) {
        newDateRepository.getDateList(firstid, secondid, date, country);
    }

    public List<ClientsReqsHobbs> getSortedClients(String sortBy) {
        return sortedClientsRepository.getClientsWithReqsHobbsSortedByName(sortBy);
    }

    public List<Archive> getArchivedMeetings() {
        return archiveRepository.getArchivedMeetings();
    }

    @Transactional
    public void updateClient(int id, String firstName, String lastName, String aboutYourself, int age, String sex, LocalDate birthdate) {
        updateClientRepository.updateClient(id, firstName, lastName, aboutYourself, age, sex, birthdate);
    }


    @Transactional
    public void archiveDate(int dateId) {
        archiveDateByIdRepository.addDateToArchive(dateId);
        archiveDateByIdRepository.removeDateFromTable(dateId);
    }

    @Transactional
    public void deleteClient(int id) {
        deleteClientById.deleteClientTraitById(id);
        deleteClientById.deleteClientRequirementById(id);
        deleteClientById.deleteClientHobbyById(id);
        deleteClientById.deleteClientById(id);
    }

    public ClientTotalMeetings getClientTotalMeetings(int id){
        return clientTotalMeetingsByIdRepository.getClientTotalMeetingsById(id);
    }

    public List<Hobbies> getClientHobbies(int clientId) {
        return clientHobbiesRepository.findHobbiesByClientId(clientId);
    }

    public List<Requirements> getClientRequirements(int clientId) {
        return clientRequirementsRepository.findRequirementsByClientId(clientId);
    }

    public List<Characters> getClientTraits(int clientId) {
        return clientTraitsRepository.findTraitsByClientId(clientId);
    }

    public DatesInfo getDateByIdInfo(int dateId) {
        return findDateByIdDateRepository.findDateById(dateId);
    }

    @Transactional
    public void updateDate(int dateId, LocalDateTime date) {
        updateDateRepository.updateDate(date, dateId);
    }
}
