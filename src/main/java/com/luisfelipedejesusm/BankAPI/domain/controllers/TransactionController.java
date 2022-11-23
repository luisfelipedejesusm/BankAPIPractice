package com.luisfelipedejesusm.BankAPI.domain.controllers;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.dto.TransactionDTO;
import com.luisfelipedejesusm.BankAPI.domain.mappers.TransactionMapper;
import com.luisfelipedejesusm.BankAPI.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions(){
        return transactionService.getAllTransactions().stream().map(transactionMapper::entityToDTO).toList();
    }

    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable Long id){
        return transactionMapper.entityToDTO(transactionService.getTransactionById(id));
    }

}
