package com.luisfelipedejesusm.BankAPI.domain.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotNull(message = "Age can not be empty")
    private Integer age;

    @NotBlank(message = "Id can not be blank")
    private String identification;

    @Embedded
    private Address address;

    private String phoneNumber;
}
