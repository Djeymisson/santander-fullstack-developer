package com.dio.petapi.service;

import com.dio.petapi.dto.PetDTO;
import com.dio.petapi.entity.Pet;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.exception.PetNotFoundException;
import com.dio.petapi.mapper.PetMapper;
import com.dio.petapi.repository.OwnerRepository;
import com.dio.petapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    private final PetMapper petMapper = PetMapper.INSTANCE;

    public PetDTO createPet(PetDTO petDTO) throws OwnerNotFoundException {
        Pet s = petMapper.toModel(petDTO);
        Long ownerId = s.getOwner().getId();

        if(ownerId != null)
            s.setOwner(ownerRepository.findById(ownerId)
                    .orElseThrow(() -> new OwnerNotFoundException(ownerId)));

        Pet savedPet = petRepository.save(s);
        return petMapper.toDTO(savedPet);
    }

    public List<PetDTO> findAll() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        return petRepository.findById(id)
                .map(petMapper::toDTO)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    public List<PetDTO> findByOwner(Long id) {
        return petRepository.findByOwnerId(id)
                .stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO updateById(Long id, PetDTO petDTO) throws PetNotFoundException {
        verifyIfExists(id);
        return petMapper
                .toDTO(petRepository
                        .save(petMapper
                                .toModel(petDTO)));
    }

    public void delete(Long id) throws PetNotFoundException {
        verifyIfExists(id);

        Pet pet = petRepository.getById(id);
        pet.setOwner(null);

        petRepository.delete(pet);
    }

    private void verifyIfExists(Long id) throws PetNotFoundException {
        if(!petRepository.existsById(id))
            throw new PetNotFoundException(id);
    }

}
