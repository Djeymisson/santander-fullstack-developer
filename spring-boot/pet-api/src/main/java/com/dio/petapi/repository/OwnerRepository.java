package com.dio.petapi.repository;

import com.dio.petapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    public Boolean existsByCpf(String cpf);

    public Boolean existsByEmail(String email);

}
