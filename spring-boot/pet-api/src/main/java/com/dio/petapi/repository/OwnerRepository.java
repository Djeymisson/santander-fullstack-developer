package com.dio.petapi.repository;

import com.dio.petapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Boolean existsByCpf(String cpf);

    Boolean existsByEmail(String email);

}
