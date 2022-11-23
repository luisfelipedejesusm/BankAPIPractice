package com.luisfelipedejesusm.BankAPI.domain.mappers;

public interface DefaultMapper<Entity, DTO> {
    DTO entityToDTO(Entity entity);
    Entity DTOtoEntity(DTO dto);

}
