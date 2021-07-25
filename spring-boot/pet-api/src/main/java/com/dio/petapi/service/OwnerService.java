package com.dio.petapi.service;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.dto.response.MessageResponseDTO;
import com.dio.petapi.entity.Owner;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.mapper.OwnerMapper;
import com.dio.petapi.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper = OwnerMapper.INSTANCE;

    public MessageResponseDTO createOwner(OwnerDTO ownerDTO) throws InfoConflictException {
        verifyInfo(ownerDTO);

        Owner ownerToSave = ownerMapper.toModel(ownerDTO);

        Owner savedOwner = ownerRepository.save(ownerToSave);
        return createMessageResponse(savedOwner.getId(), "Created owner with ID ");
    }

    public MessageResponseDTO updateById(Long id, OwnerDTO ownerDTO) throws OwnerNotFoundException {
        verifyIfExists(id);

        Owner ownerToUpdate = ownerMapper.toModel(ownerDTO);

        Owner updatedOwner = ownerRepository.save(ownerToUpdate);
        return createMessageResponse(updatedOwner.getId(), "Updated owner with ID ");
    }

    private void verifyInfo(OwnerDTO ownerDTO) throws InfoConflictException {
        if(ownerRepository.existsByCpf(ownerDTO.getCpf()))
            throw new InfoConflictException("CPF");

        if(ownerRepository.existsByEmail(ownerDTO.getEmail()))
            throw new InfoConflictException("E-mail");

    }

    private void verifyIfExists(Long id) throws OwnerNotFoundException {
        if(ownerRepository.existsById(id))
            throw new OwnerNotFoundException(id);
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
