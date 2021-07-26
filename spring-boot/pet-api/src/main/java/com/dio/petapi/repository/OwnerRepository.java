package com.dio.petapi.repository;

import com.dio.petapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Boolean existsByCpf(String cpf);

    Boolean existsByEmail(String email);

}
