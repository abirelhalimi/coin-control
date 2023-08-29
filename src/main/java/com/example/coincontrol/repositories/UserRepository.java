package com.example.coincontrol.repositories;


import com.example.coincontrol.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
