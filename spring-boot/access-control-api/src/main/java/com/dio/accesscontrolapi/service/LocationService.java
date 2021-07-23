package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Location;
import com.dio.accesscontrolapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public Optional<Location> update(Location location) {
        return locationRepository.findById(location.getId())
                .map(w -> locationRepository.save(location));
    }

    public Boolean delete(Long id) {
        return locationRepository.findById(id)
                .map(w -> {
                    locationRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
