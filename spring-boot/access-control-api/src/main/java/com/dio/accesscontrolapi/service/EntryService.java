package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Entry;
import com.dio.accesscontrolapi.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    public Optional<Entry> findById(Long id) {
        return entryRepository.findById(id);
    }

    public Optional<Entry> update(Entry entry, Long id) {
        return entryRepository.findById(id)
                .map(x -> entryRepository.save(entry));
    }

    public Boolean delete(Long id) {
        return entryRepository.findById(id)
                .map(x -> {
                    entryRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
