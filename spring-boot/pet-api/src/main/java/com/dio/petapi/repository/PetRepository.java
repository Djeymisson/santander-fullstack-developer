package com.dio.petapi.repository;

import com.dio.petapi.entity.Owner;
import com.dio.petapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
