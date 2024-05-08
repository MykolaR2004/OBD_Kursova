package com.example.obd_kursova.services;

import com.example.obd_kursova.model.ClientInfo;
import com.example.obd_kursova.model.ClientsReqsHobbs;
import com.example.obd_kursova.repositories.ClientRepository;
import com.example.obd_kursova.repositories.ClientInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientInfoRepository clientInfoRepository;

    public List<ClientsReqsHobbs> getClients() {
        return clientRepository.getClientsWithReqsHobbs();
    }

    public List<ClientInfo> getClientInfo(int id){
        return clientInfoRepository.getClientInfo(id);
    }
}
