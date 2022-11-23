package com.luisfelipedejesusm.BankAPI.domain.controllers;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.dto.TransactionDTO;
import com.luisfelipedejesusm.BankAPI.domain.mappers.AccountMapper;
import com.luisfelipedejesusm.BankAPI.domain.service.AccountService;
import com.luisfelipedejesusm.BankAPI.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts(){
        return accountService.getAllAccounts().stream().map(accountMapper::entityToDTO).toList();
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable Long id){
        return accountMapper.entityToDTO(accountService.getAccountById(id));
    }

    @PostMapping("/{id}/transaction")
    public ResponseEntity<?> addAccountTransaction(@PathVariable Long accountId, @RequestBody @Valid TransactionDTO transactionDTO){
        transactionService.addTransaction(accountId, transactionDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable Long id){
        accountService.updateAccount(accountDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
