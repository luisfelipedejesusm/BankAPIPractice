package com.luisfelipedejesusm.BankAPI.domain.service;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.dto.ClientDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Client;
import com.luisfelipedejesusm.BankAPI.domain.exception.ClientNotFoundException;
import com.luisfelipedejesusm.BankAPI.domain.mappers.ClientMapper;
import com.luisfelipedejesusm.BankAPI.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public Client getClientById(Long id) {
        return null;
    }

    public List<Client> getAllClients() {
        return null;
    }

    public void updateClient(ClientDTO clientDTO, Long id) {
        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        client.setName(clientDTO.getName());
        client.setAge(client.getAge());
        client.setIdentification(client.getIdentification());
        if (clientDTO.getAddress() != null)
            client.setAddress(clientDTO.getAddress());
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
    }

    public void addClientAccount(AccountDTO accountDTO, Long clientId) {
    }

    public void addClient(ClientDTO clientDTO) {
        Client client = clientMapper.DTOtoEntity(clientDTO);
        clientRepository.save(client);
    }
}
