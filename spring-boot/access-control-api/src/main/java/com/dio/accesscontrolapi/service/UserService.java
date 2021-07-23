package com.dio.accesscontrolapi.service;

import com.dio.accesscontrolapi.model.User;
import com.dio.accesscontrolapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> update(User user) {
        return userRepository.findById(user.getId())
                .map(u -> userRepository.save(user));
    }

    public Boolean delete(Long id) {
        return userRepository.findById(id)
                .map(u -> {
                    userRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
