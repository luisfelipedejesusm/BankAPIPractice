package com.luisfelipedejesusm.BankAPI.domain.service;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Account;
import com.luisfelipedejesusm.BankAPI.domain.exception.AccountNotFoundException;
import com.luisfelipedejesusm.BankAPI.domain.mappers.AccountMapper;
import com.luisfelipedejesusm.BankAPI.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public void updateAccount(AccountDTO accountDTO, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        // Logically, none of the attributes in account should be updated except for the status
        account.setStatus(account.getStatus());

        accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void addAccount(AccountDTO accountDTO, Long clientId) {
    }
}
