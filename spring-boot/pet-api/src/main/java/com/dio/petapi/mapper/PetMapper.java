package com.dio.petapi.mapper;

import com.dio.petapi.dto.PetDTO;
import com.dio.petapi.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    Pet toModel(PetDTO ownerDTO);

    PetDTO toDTO(Pet owner);

}
