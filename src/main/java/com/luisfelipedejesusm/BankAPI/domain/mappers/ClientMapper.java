package com.luisfelipedejesusm.BankAPI.domain.mappers;

import com.luisfelipedejesusm.BankAPI.domain.dto.ClientDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements DefaultMapper<Client, ClientDTO>{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientDTO entityToDTO(Client client) {
        return ClientDTO.builder()
                .name(client.getName())
                .age(client.getAge())
                .identification(client.getIdentification())
                .address(client.getAddress())
                .build();
    }

    @Override
    public Client DTOtoEntity(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .age(clientDTO.getAge())
                .identification(clientDTO.getIdentification())
                .address(clientDTO.getAddress())
                .username(clientDTO.getUsername())
                .password(passwordEncoder.encode(clientDTO.getPassword()))
                .build();
    }
}
