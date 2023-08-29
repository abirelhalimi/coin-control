package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.Budget;
import com.example.coincontrol.repositories.BudgetRepository;
import com.example.coincontrol.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Budget add(Budget budget) {
        return null;
    }

    @Override
    public Budget update(Long id, Budget newBudgetData) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Budget getById(Long id) {
        return null;
    }

    @Override
    public List<Budget> getAll() {
        return null;
    }
}
