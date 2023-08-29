package com.example.coincontrol.services;

import com.example.coincontrol.models.BudgetPeriod;

import java.util.List;

public interface BudgetPeriodService {
    BudgetPeriod add(BudgetPeriod budget);

    BudgetPeriod update(Long id, BudgetPeriod newBudgetData);

    void delete(Long id);

    BudgetPeriod getById(Long id);

    List<BudgetPeriod> getAll();
}
