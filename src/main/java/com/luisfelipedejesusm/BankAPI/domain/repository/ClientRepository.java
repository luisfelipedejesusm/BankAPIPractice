package com.luisfelipedejesusm.BankAPI.domain.repository;

import com.luisfelipedejesusm.BankAPI.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
