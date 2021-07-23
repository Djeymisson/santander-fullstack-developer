package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.UserCategory;
import com.dio.accesscontrolapi.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    @Autowired
    UserCategoryRepository userCategoryRepository;

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public UserCategory save(UserCategory userCategory) {
        return userCategoryRepository.save(userCategory);
    }

    public Optional<UserCategory> findById(Long id) {
        return userCategoryRepository.findById(id);
    }

    public Optional<UserCategory> update(UserCategory userCategory) {
        return userCategoryRepository.findById(userCategory.getId())
                .map(x -> userCategoryRepository.save(userCategory));
    }

    public Boolean delete(Long id) {
        return userCategoryRepository.findById(id)
                .map(x -> {
                    userCategoryRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
