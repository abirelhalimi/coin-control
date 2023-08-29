package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.BudgetPeriod;
import com.example.coincontrol.repositories.BudgetPeriodRepository;
import com.example.coincontrol.services.BudgetPeriodService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPeriodServiceImpl implements BudgetPeriodService {
    @Autowired
    private BudgetPeriodRepository budgetPeriodRepository;

    @Override
    public BudgetPeriod add(BudgetPeriod budget) {
        return budgetPeriodRepository.save(budget);
    }

    @Override
    public BudgetPeriod update(Long id, BudgetPeriod newBudgetData) {
        BudgetPeriod existingBudgetPeriod = getById(id);

        if (newBudgetData.getMonth() != null) {
            existingBudgetPeriod.setMonth(newBudgetData.getMonth());
        }
        if (newBudgetData.getYear() != null) {
            existingBudgetPeriod.setYear(newBudgetData.getYear());
        }
        return budgetPeriodRepository.save(existingBudgetPeriod);
    }

    @Override
    public void delete(Long id) {
        budgetPeriodRepository.delete(getById(id));
    }

    @Override
    public BudgetPeriod getById(Long id) {
        return budgetPeriodRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("budgetPeriod not found"));
    }

    @Override
    public List<BudgetPeriod> getAll() {
        return budgetPeriodRepository.findAll();
    }
}
