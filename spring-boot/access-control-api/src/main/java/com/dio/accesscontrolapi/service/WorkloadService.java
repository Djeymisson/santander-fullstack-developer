package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Workload;
import com.dio.accesscontrolapi.repository.WorkloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkloadService {

    @Autowired
    WorkloadRepository workloadRepository;

    public List<Workload> findAll() {
        return workloadRepository.findAll();
    }

    public Workload save(Workload workload) {
        return workloadRepository.save(workload);
    }

    public Optional<Workload> findById(Long id) {
        return workloadRepository.findById(id);
    }

    public Optional<Workload> update(Workload w) {
        return workloadRepository.findById(w.getId())
                .map(workload -> {
                    workload.setDescription(w.getDescription());
                    return workloadRepository.save(workload);
                });
    }

    public Boolean delete(Long id) {
        return workloadRepository.findById(id)
                .map(w -> {
                    workloadRepository.deleteById(w.getId());
                    return true;
                }).orElse(false);
    }
}
