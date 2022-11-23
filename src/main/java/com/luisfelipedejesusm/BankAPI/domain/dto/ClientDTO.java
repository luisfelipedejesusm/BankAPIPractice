package com.luisfelipedejesusm.BankAPI.domain.dto;

import com.luisfelipedejesusm.BankAPI.domain.entities.Address;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ClientDTO {
    private String name;
    private Integer age;
    private String identification;
    private Address address;
    private String username;
    private String password;
}
