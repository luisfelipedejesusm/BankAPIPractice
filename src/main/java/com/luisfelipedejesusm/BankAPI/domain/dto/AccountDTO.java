package com.luisfelipedejesusm.BankAPI.domain.dto;

import com.luisfelipedejesusm.BankAPI.domain.constants.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String accountId;
    private AccountType accountType;
    private Double initialAmount;
    private String status;
}
