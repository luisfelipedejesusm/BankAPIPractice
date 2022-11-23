package com.luisfelipedejesusm.BankAPI.domain.controllers;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.dto.ClientDTO;
import com.luisfelipedejesusm.BankAPI.domain.mappers.ClientMapper;
import com.luisfelipedejesusm.BankAPI.domain.service.AccountService;
import com.luisfelipedejesusm.BankAPI.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final AccountService accountService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, AccountService accountService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.accountService = accountService;
        this.clientMapper = clientMapper;
    }

    @GetMapping
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients().stream().map(clientMapper::entityToDTO).toList();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id){
        return clientMapper.entityToDTO(clientService.getClientById(id));
    }

    @PostMapping("{id}")
    public ResponseEntity<?> addClient(@RequestBody @Valid ClientDTO clientDTO){
        clientService.addClient(clientDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/account")
    public ResponseEntity<?> addClientAccount(@RequestBody @Valid AccountDTO accountDTO, @PathVariable Long clientId){
        accountService.addAccount(accountDTO, clientId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateClient(@RequestBody @Valid ClientDTO clientDTO, @PathVariable Long id){
        clientService.updateClient(clientDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
