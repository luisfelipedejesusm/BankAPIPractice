package com.luisfelipedejesusm.BankAPI.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE clients SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Client extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String status;

    @OneToMany(mappedBy = "client")
    private List<Account> accountList;

    private Boolean deleted;
}
