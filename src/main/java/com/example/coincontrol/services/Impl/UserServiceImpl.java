package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.User;
import com.example.coincontrol.repositories.UserRepository;
import com.example.coincontrol.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User newUserData) {
        User existingUser = getById(id);

        if(newUserData.getUsername() != null) {
            existingUser.setUsername(newUserData.getUsername());
        }

        if(newUserData.getEmail() != null) {
            existingUser.setEmail(newUserData.getEmail());
        }

        if(newUserData.getPassword() != null) {
            existingUser.setPassword(newUserData.getPassword());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
