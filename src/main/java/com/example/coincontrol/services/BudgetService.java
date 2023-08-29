package com.example.coincontrol.services;

import com.example.coincontrol.models.Budget;

import java.util.List;

public interface BudgetService {

    Budget add(Budget budget);

    Budget update(Long id, Budget newBudgetData);

    void delete(Long id);

    Budget getById(Long id);

    List<Budget> getAll();
}
