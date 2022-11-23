package com.luisfelipedejesusm.BankAPI.domain.dto;

import com.luisfelipedejesusm.BankAPI.domain.constants.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TransactionDTO {
    private LocalDate date;
    private TransactionType transactionType;
    private Double transactionAmount;
    private Double accountBalance;
}
