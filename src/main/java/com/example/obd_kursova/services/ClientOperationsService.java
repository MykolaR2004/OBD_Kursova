package com.example.obd_kursova.services;

import com.example.obd_kursova.model.Characters;
import com.example.obd_kursova.model.Hobbies;
import com.example.obd_kursova.model.Requirements;
import com.example.obd_kursova.repositories.onClientOperations.NewClientRepository;
import com.example.obd_kursova.repositories.clientAttributes.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class ClientOperationsService {
    private final NewClientRepository newClientRepository;
    private final AddHobbyRepository addHobbyRepository;
    private final DeleteHobbyRepository deleteHobbyRepository;
    private final AddRequirementRepository addRequirementRepository;
    private final DeleteRequirementRepository deleteRequirementRepository;
    private final AddTraitRepository addTraitRepository;
    private final DeleteTraitRepository deleteTraitRepository;
    private final AvailableHobbiesRepository availableHobbiesRepository;
    private final AvailableTraitsRepository availableTraitsRepository;
    private final AvailableRequirementsRepository availableRequirementsRepository;

    @Transactional
    public void addClient(String firstName, String lastName, String aboutYourself, int age, String sex, LocalDate birthdate, int hobbyId, int requirementId, int traitId) {
        newClientRepository.insertClient(firstName, lastName, aboutYourself, age, sex, birthdate, "images/client_photo.jpg");
        Integer clientId = newClientRepository.getLastInsertId();
        newClientRepository.insertHobby(clientId, hobbyId);
        newClientRepository.insertRequirement(clientId, requirementId);
        newClientRepository.insertTrait(clientId, traitId);
    }

    @Transactional
    public void addHobbyToClient(int clientId, int hobbyId) {
        addHobbyRepository.insertHobby(clientId, hobbyId);
    }

    @Transactional
    public void removeHobbyFromClient(int clientId, int hobbyId) {
        deleteHobbyRepository.deleteHobby(clientId, hobbyId);
    }

    @Transactional
    public void addRequirementToClient(int clientId, int requirementId) {
        addRequirementRepository.insertRequirement(clientId, requirementId);
    }

    @Transactional
    public void removeRequirementFromClient(int clientId, int requirementId) {
        deleteRequirementRepository.deleteRequirement(clientId, requirementId);
    }

    @Transactional
    public void addTraitToClient(int clientId, int traitId) {
        addTraitRepository.insertTrait(clientId, traitId);
    }

    @Transactional
    public void removeTraitFromClient(int clientId, int traitId) {
        deleteTraitRepository.deleteTrait(clientId, traitId);
    }


    public List<Hobbies> getAvailableHobbies(int clientId) {
        return availableHobbiesRepository.findAvailableHobbiesByClientId(clientId);
    }

    public List<Requirements> getAvailableRequirements(int clientId) {
        return availableRequirementsRepository.findAvailableRequirementsByClientId(clientId);
    }

    public List<Characters> getAvailableCharacters(int clientId) {
        return availableTraitsRepository.findAvailableTraitsByClientId(clientId);
    }

}

