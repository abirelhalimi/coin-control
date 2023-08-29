package com.example.coincontrol.repositories;

import com.example.coincontrol.models.BudgetPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetPeriodRepository extends JpaRepository<BudgetPeriod, Long> {
}
