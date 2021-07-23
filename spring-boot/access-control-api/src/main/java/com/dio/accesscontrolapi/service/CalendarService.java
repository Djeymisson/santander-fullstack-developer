package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Calendar;
import com.dio.accesscontrolapi.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Optional<Calendar> findById(Long id) {
        return calendarRepository.findById(id);
    }

    public Optional<Calendar> update(Calendar c) {
        return calendarRepository.findById(c.getId())
                .map(calendar -> calendarRepository.save(c));
    }

    public Boolean delete(Long id) {
        return calendarRepository.findById(id)
                .map(c -> {
                    calendarRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
