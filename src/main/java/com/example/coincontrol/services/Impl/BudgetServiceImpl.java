package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.Budget;
import com.example.coincontrol.repositories.BudgetRepository;
import com.example.coincontrol.services.BudgetService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Budget add(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Budget update(Long id, Budget newBudgetData) {
        Budget existingBudget = getById(id);

        if (newBudgetData.getBudgetAmount() != null) {
            existingBudget.setBudgetAmount(newBudgetData.getBudgetAmount());
        }

        if (newBudgetData.getCategory() != null) {
            existingBudget.setCategory(newBudgetData.getCategory());
        }

        if (newBudgetData.getActualAmount() != null) {
            existingBudget.setActualAmount(newBudgetData.getActualAmount());
        }

        return budgetRepository.save(existingBudget);
    }

    @Override
    public void delete(Long id) {
        budgetRepository.delete(getById(id));
    }

    @Override
    public Budget getById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("budget not found"));
    }

    @Override
    public List<Budget> getAll() {
        return budgetRepository.findAll();
    }
}
