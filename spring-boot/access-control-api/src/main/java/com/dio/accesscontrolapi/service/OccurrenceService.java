package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Occurrence;
import com.dio.accesscontrolapi.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    @Autowired
    OccurrenceRepository occurrenceRepository;

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }

    public Occurrence save(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }

    public Optional<Occurrence> findById(Long id) {
        return occurrenceRepository.findById(id);
    }

    public Optional<Occurrence> update(Occurrence occurrence) {
        return occurrenceRepository.findById(occurrence.getId())
                .map(x -> occurrenceRepository.save(occurrence));
    }

    public Boolean delete(Long id) {
        return occurrenceRepository.findById(id)
                .map(x -> {
                    occurrenceRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
