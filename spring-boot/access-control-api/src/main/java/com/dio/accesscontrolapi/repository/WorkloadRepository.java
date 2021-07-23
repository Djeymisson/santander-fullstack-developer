package com.dio.accesscontrolapi.repository;

import com.dio.accesscontrolapi.model.Workload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkloadRepository extends JpaRepository<Workload, Long> {
}
