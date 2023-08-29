package com.example.coincontrol.services;

import com.example.coincontrol.models.Budget;
import com.example.coincontrol.models.Category;
import com.example.coincontrol.repositories.BudgetRepository;
import com.example.coincontrol.services.Impl.BudgetServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class BudgetServiceTests {

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetServiceImpl budgetService;

    @Test
    public void shouldCreateANewBudget() {
        Budget expectedBudget = new Budget();
        expectedBudget.setBudgetAmount(10.2);
        expectedBudget.setCategory(new Category());
        expectedBudget.setActualAmount(9.8);

        when(budgetRepository.save(Mockito.any(Budget.class))).thenReturn(expectedBudget);

        Budget createdBudget = budgetService.add(expectedBudget);
        assertNotNull(createdBudget);
        assertEquals(expectedBudget.getBudgetAmount(), createdBudget.getBudgetAmount());
        assertEquals(expectedBudget.getCategory(), createdBudget.getCategory());
        assertEquals(expectedBudget.getActualAmount(), createdBudget.getActualAmount());
    }

    @Test
    public void shouldReturnTheBudgetGivenAnId() {

        Long id = 1L;
        Budget expectedBudget = new Budget();
        expectedBudget.setId(id);

        when(budgetRepository.findById(id)).thenReturn(Optional.of(expectedBudget));

        Budget retrievedBudget = budgetService.getById(id);

        assertEquals(expectedBudget, retrievedBudget);

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldReturnNotFoundGivenAWrongId() {

        Long id = 1L;
        when(budgetRepository.findById(id)).thenReturn(Optional.empty());
        budgetService.getById(id);
    }

    @Test
    public void shouldUpdatedChangedFieldsInBudget() {

        Long id = 1L;

        Budget existingBudget = new Budget();
        existingBudget.setBudgetAmount(10.2);
        existingBudget.setActualAmount(2.6);

        Budget updatedBudget = new Budget();
        updatedBudget.setActualAmount(5.7);

        when(budgetRepository.findById(id)).thenReturn(Optional.of(existingBudget));
        when(budgetRepository.save(Mockito.any(Budget.class))).thenReturn(existingBudget);

        Budget actual = budgetService.update(id, updatedBudget);

        assertNotNull(actual);
        assertEquals(existingBudget.getBudgetAmount(), actual.getBudgetAmount());
        assertEquals(updatedBudget.getActualAmount(), actual.getActualAmount());

    }

    @Test
    public void shouldDeleteBudgetGivenId() {
        Long id = 1L;

        Budget budget = new Budget();
        budget.setId(id);

        when(budgetRepository.findById(id)).thenReturn(Optional.of(budget));

        budgetService.delete(id);

        verify(budgetRepository, times(1)).delete(budget);

    }
}
