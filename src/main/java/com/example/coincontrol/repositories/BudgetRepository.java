package com.example.coincontrol.repositories;

import com.example.coincontrol.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
