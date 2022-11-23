package com.luisfelipedejesusm.BankAPI.domain.entities;

import com.luisfelipedejesusm.BankAPI.domain.constants.TransactionType;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@SQLDelete(sql = "UPDATE transactions SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private TransactionType transactionType;

    private Double transactionAmount;

    private Double accountBalance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private Boolean deleted;
}
