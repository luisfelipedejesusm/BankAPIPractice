package com.luisfelipedejesusm.BankAPI.domain.mappers;

import com.luisfelipedejesusm.BankAPI.domain.dto.TransactionDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements DefaultMapper<Transaction, TransactionDTO> {
    @Override
    public TransactionDTO entityToDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .date(transaction.getDate())
                .transactionType(transaction.getTransactionType())
                .transactionAmount(transaction.getTransactionAmount())
                .accountBalance(transaction.getAccountBalance())
                .build();
    }

    @Override
    public Transaction DTOtoEntity(TransactionDTO transactionDTO) {
        return null;
    }
}
