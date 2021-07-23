package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.AccessLevel;
import com.dio.accesscontrolapi.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    @Autowired
    AccessLevelRepository accessLevelRepository;

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public AccessLevel save(AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public Optional<AccessLevel> findById(Long id) {
        return accessLevelRepository.findById(id);
    }

    public Optional<AccessLevel> update(AccessLevel accessLevel) {
        return accessLevelRepository.findById(accessLevel.getId())
                .map(a -> accessLevelRepository.save(accessLevel));
    }

    public Boolean delete(Long id) {
        return accessLevelRepository.findById(id)
                .map(a -> {
                    accessLevelRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
