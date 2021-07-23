package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.BankTime;
import com.dio.accesscontrolapi.repository.BankTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankTimeService {

    @Autowired
    BankTimeRepository bankTimeRepository;

    public List<BankTime> findAll() {
        return bankTimeRepository.findAll();
    }

    public BankTime save(BankTime bankTime) {
        return bankTimeRepository.save(bankTime);
    }

    public Optional<BankTime> findById(BankTime.BankTimeId id) {
        return bankTimeRepository.findById(id);
    }

    public Optional<BankTime> update(BankTime bankTime) {
        return bankTimeRepository.findById(bankTime.getId())
                .map(b -> bankTimeRepository.save(bankTime));
    }

    public Boolean delete(BankTime.BankTimeId id) {
        return bankTimeRepository.findById(id)
                .map(b -> {
                    bankTimeRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
