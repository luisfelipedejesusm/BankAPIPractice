package com.luisfelipedejesusm.BankAPI.domain.repository;

import com.luisfelipedejesusm.BankAPI.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
