package com.luisfelipedejesusm.BankAPI.domain.service;

import com.luisfelipedejesusm.BankAPI.domain.dto.TransactionDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {
    public List<Transaction> getAllTransactions() {
        return null;
    }

    public Transaction getTransactionById(Long id) {
        return null;
    }

    public void addTransaction(Long accountId, TransactionDTO transactionDTO) {

    }
}

