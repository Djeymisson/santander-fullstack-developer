package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.Company;
import com.dio.accesscontrolapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<Company> update(Company company) {
        return companyRepository.findById(company.getId())
                .map(c -> companyRepository.save(company));
    }

    public Boolean delete(Long id) {
        return companyRepository.findById(id)
                .map(c -> {
                    companyRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
