package com.example.coincontrol.services;

import com.example.coincontrol.models.BudgetPeriod;
import com.example.coincontrol.models.Transaction;
import com.example.coincontrol.repositories.BudgetPeriodRepository;
import com.example.coincontrol.services.Impl.BudgetPeriodServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Month;
import java.time.Year;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class BudgetPeriodServiceTests {

    @Mock
    private BudgetPeriodRepository budgetPeriodRepository;

    @InjectMocks
    private BudgetPeriodServiceImpl budgetPeriodService;

    @Test
    public void shouldCreateANewBudgetPeriod() {

        BudgetPeriod expectedBudgetPeriod = new BudgetPeriod();

        expectedBudgetPeriod.setMonth(Month.AUGUST);
        expectedBudgetPeriod.setYear(Year.of(2023));

        when(budgetPeriodRepository.save(Mockito.any(BudgetPeriod.class))).thenReturn(expectedBudgetPeriod);

        BudgetPeriod createdBudgetPeriod = budgetPeriodService.add(expectedBudgetPeriod);

        assertNotNull(createdBudgetPeriod);
        assertEquals(expectedBudgetPeriod.getMonth(), createdBudgetPeriod.getMonth());
        assertEquals(expectedBudgetPeriod.getYear(), createdBudgetPeriod.getYear());

    }

    @Test
    public void shouldReturnTheBudgetPeriodGivenAnId() {

        Long id = 1L;
        BudgetPeriod expectedBudgetPeriod = new BudgetPeriod();
        expectedBudgetPeriod.setId(id);

        when(budgetPeriodRepository.findById(id)).thenReturn(Optional.of(expectedBudgetPeriod));

        BudgetPeriod retrievedBudgetPeriod = budgetPeriodService.getById(id);

        assertEquals(expectedBudgetPeriod, retrievedBudgetPeriod);

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldReturnNotFoundGivenAWrongId() {

        Long id = 1L;
        when(budgetPeriodRepository.findById(id)).thenReturn(Optional.empty());
        budgetPeriodService.getById(id);

    }

    @Test
    public void shouldUpdateChangedFieldsInBudgetPeriod() {

        Long id = 1L;

        BudgetPeriod existingBudgetPeriod = new BudgetPeriod();
        existingBudgetPeriod.setMonth(Month.AUGUST);
        existingBudgetPeriod.setYear(Year.of(2023));

        BudgetPeriod updatedBudgetPeriod = new BudgetPeriod();
        updatedBudgetPeriod.setMonth(Month.SEPTEMBER);

        when(budgetPeriodRepository.findById(id)).thenReturn(Optional.of(existingBudgetPeriod));
        when(budgetPeriodRepository.save(Mockito.any(BudgetPeriod.class))).thenReturn(existingBudgetPeriod);

        BudgetPeriod actual = budgetPeriodService.update(id, updatedBudgetPeriod);

        assertNotNull(actual);
        assertEquals(existingBudgetPeriod.getYear(), actual.getYear());
        assertEquals(updatedBudgetPeriod.getMonth(), actual.getMonth());

    }

    @Test
    public void shouldDeleteBudgetPeriodGivenId() {
        Long id = 1L;

        BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setId(id);

        when(budgetPeriodRepository.findById(id)).thenReturn(Optional.of(budgetPeriod));

        budgetPeriodService.delete(id);

        verify(budgetPeriodRepository, times(1)).delete(budgetPeriod);

    }

}
