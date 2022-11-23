package com.luisfelipedejesusm.BankAPI.domain.mappers;

import com.luisfelipedejesusm.BankAPI.domain.dto.AccountDTO;
import com.luisfelipedejesusm.BankAPI.domain.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements DefaultMapper<Account, AccountDTO>{

    @Override
    public AccountDTO entityToDTO(Account account) {
        return AccountDTO.builder()
                .accountId(account.getAccountId())
                .accountType(account.getAccountType())
                .initialAmount(account.getInitialAmount())
                .status(account.getStatus())
                .build();
    }

    @Override
    public Account DTOtoEntity(AccountDTO accountDTO) {
        return null;
    }
}
