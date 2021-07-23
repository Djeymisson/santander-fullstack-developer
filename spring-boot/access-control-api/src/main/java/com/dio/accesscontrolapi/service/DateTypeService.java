package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.DateType;
import com.dio.accesscontrolapi.repository.DateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DateTypeService {

    @Autowired
    DateTypeRepository dateTypeRepository;

    public List<DateType> findAll() {
        return dateTypeRepository.findAll();
    }

    public DateType save(DateType dateType) {
        return dateTypeRepository.save(dateType);
    }

    public Optional<DateType> findById(Long id) {
        return dateTypeRepository.findById(id);
    }

    public Optional<DateType> update(DateType dateType) {
        return dateTypeRepository.findById(dateType.getId())
                .map(x -> dateTypeRepository.save(dateType));
    }

    public Boolean delete(Long id) {
        return dateTypeRepository.findById(id)
                .map(x -> {
                    dateTypeRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
