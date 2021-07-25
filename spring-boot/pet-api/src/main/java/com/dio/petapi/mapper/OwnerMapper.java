package com.dio.petapi.mapper;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    Owner toModel(OwnerDTO ownerDTO);

    OwnerDTO toDTO(Owner owner);

}
