package com.dio.petapi.service;

import com.dio.petapi.dto.OwnerDTO;
import com.dio.petapi.entity.Owner;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.dio.petapi.utils.OwnerUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerService ownerService;

    @Test
    void testGivenOwnerDTOThenReturnOwnerDTOWithId() throws InfoConflictException {
        OwnerDTO ownerDTO = createFakeDTO();
        OwnerDTO savedDTO = createFakeSavedDTO();
        Owner entity = createFakeEntity();

        when(ownerRepository.save(any(Owner.class))).thenReturn(entity);

        OwnerDTO returnedOwner = ownerService.createOwner(ownerDTO);
        assertEquals(savedDTO, returnedOwner);
        assertEquals(savedDTO.getId(), returnedOwner.getId());
    }

    @Test
    void testGivenValidOwnerIdThenReturnThisOwner() throws OwnerNotFoundException {
        OwnerDTO savedDTO = createFakeSavedDTO();
        Owner entity = createFakeEntity();

        when(ownerRepository.findById(entity.getId())).thenReturn(Optional.of(entity));

        OwnerDTO foundOwner = ownerService.findById(entity.getId());

        assertEquals(savedDTO, foundOwner);
        assertEquals(savedDTO.getId(), foundOwner.getId());
        assertEquals(savedDTO.getName(), foundOwner.getName());
    }

    @Test
    void testGivenInvalidOwnerIdThenThrowException() {
        var invalidId = 1L;
        when(ownerRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(Owner.class)));

        assertThrows(OwnerNotFoundException.class, () -> ownerService.findById(invalidId));
    }

    @Test
    void testGivenValidOwnerIdAndUpdateInfoThenReturnSuccessOnUpdate() throws OwnerNotFoundException {
        var ownerId = 2L;

        OwnerDTO toUpdateDTO = createFakeDTO();
        toUpdateDTO.setId(ownerId);
        toUpdateDTO.getPhones().forEach(phoneDTO -> phoneDTO.setId(ownerId));
        toUpdateDTO.setEmail("teste@tes.com");

        Owner updatedEntity = createFakeEntity();
        updatedEntity.setId(toUpdateDTO.getId());
        updatedEntity.getPhones().forEach(phone -> phone.setId(toUpdateDTO.getId()));
        updatedEntity.setEmail(toUpdateDTO.getEmail());

        when(ownerRepository.existsById(ownerId)).thenReturn(true);
        when(ownerRepository.save(any(Owner.class))).thenReturn(updatedEntity);

        assertEquals(toUpdateDTO, ownerService.updateById(ownerId, toUpdateDTO));
    }

    @Test
    void testGivenInvalidOwnerIdAndUpdateInfoThenThrowExceptionOnUpdate() {
        var ownerId = 2L;

        OwnerDTO toUpdateDTO = createFakeDTO();
        toUpdateDTO.setId(ownerId);
        toUpdateDTO.getPhones().forEach(phoneDTO -> phoneDTO.setId(ownerId));
        toUpdateDTO.setEmail("teste@tes.com");

        when(ownerRepository.existsById(ownerId)).thenReturn(false);

        assertThrows(OwnerNotFoundException.class, () -> ownerService.updateById(ownerId, toUpdateDTO));
    }

    @Test
    void testGivenValidOwnerIdThenReturnSuccessOnDelete() throws OwnerNotFoundException {
        var ownerId = 1L;

        Owner owner = createFakeEntity();

        when(ownerRepository.existsById(ownerId)).thenReturn(true);
        ownerService.delete(ownerId);

        verify(ownerRepository, times(1)).deleteById(ownerId);
    }

    @Test
    void testGivenInvalidOwnerIdThenThrowExceptionOnDelete() {
        var ownerId = 1L;

        when(ownerRepository.existsById(ownerId)).thenReturn(false);

        assertThrows(OwnerNotFoundException.class, () -> ownerService.delete(ownerId));
    }
}
