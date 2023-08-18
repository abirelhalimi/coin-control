package com.example.coincontrol.repositories;


import com.example.coincontrol.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
