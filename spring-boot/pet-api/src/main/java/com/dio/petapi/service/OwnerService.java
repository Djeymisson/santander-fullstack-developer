package com.dio.petapi.service;

import com.dio.petapi.dto.OwnerDTO;
import com.dio.petapi.entity.Owner;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.mapper.OwnerMapper;
import com.dio.petapi.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper = OwnerMapper.INSTANCE;

    public OwnerDTO createOwner(OwnerDTO ownerDTO) throws InfoConflictException {
        verifyInfo(ownerDTO);

        Owner savedOwner = ownerRepository.save(ownerMapper.toModel(ownerDTO));

        return ownerMapper.toDTO(savedOwner);
    }

    public List<OwnerDTO> findAll() {
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OwnerDTO findById(Long id) throws OwnerNotFoundException {
        return ownerRepository.findById(id)
                .map(ownerMapper::toDTO)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    public OwnerDTO updateById(Long id, OwnerDTO ownerDTO) throws OwnerNotFoundException {
        verifyIfExists(id);

        Owner updatedOwner = ownerRepository.save(ownerMapper.toModel(ownerDTO));
        
        return ownerMapper.toDTO(updatedOwner);
    }

    public void delete(Long id) throws OwnerNotFoundException {
        verifyIfExists(id);

        ownerRepository.deleteById(id);
    }

    private void verifyInfo(OwnerDTO ownerDTO) throws InfoConflictException {
        if(ownerRepository.existsByCpf(ownerDTO.getCpf()))
            throw new InfoConflictException("CPF");

        if(ownerRepository.existsByEmail(ownerDTO.getEmail()))
            throw new InfoConflictException("E-mail");

    }

    private void verifyIfExists(Long id) throws OwnerNotFoundException {
        if(!ownerRepository.existsById(id))
            throw new OwnerNotFoundException(id);
    }

}
