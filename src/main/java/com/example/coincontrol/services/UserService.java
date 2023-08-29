package com.example.coincontrol.services;

import com.example.coincontrol.models.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User update(Long id, User newObjectData);

    void delete(Long id);

    List<User> getAll();

    User getById(Long id);
}
