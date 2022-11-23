package com.luisfelipedejesusm.BankAPI.domain.entities;

import com.luisfelipedejesusm.BankAPI.domain.constants.AccountType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    private AccountType accountType;

    private Double initialAmount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Transaction> transactionList;

    private Boolean deleted;
}
