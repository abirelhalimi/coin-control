package com.example.coincontrol.services;

import com.example.coincontrol.models.Transaction;
import com.example.coincontrol.repositories.TransactionRepository;
import com.example.coincontrol.services.Impl.TransactionServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTests {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void shouldCreateANewTransaction() {

        Transaction expectedTransaction = new Transaction();
        expectedTransaction.setAmount(1.3);
        expectedTransaction.setDate(new Date(2023, 8, 28));
        expectedTransaction.setDescription("Transaction Description");

        when(transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(expectedTransaction);

        Transaction createdTransaction = transactionService.add(expectedTransaction);

        assertNotNull(createdTransaction);
        assertEquals(expectedTransaction.getDate(), createdTransaction.getDate());
        assertEquals(expectedTransaction.getAmount(), createdTransaction.getAmount());
        assertEquals(expectedTransaction.getDescription(), createdTransaction.getDescription());

    }

    @Test
    public void shoudReturnTheTransactionGivenAnId() {

        Long id = 1L;
        Transaction expectedTransaction = new Transaction();
        expectedTransaction.setId(id);

        when(transactionRepository.findById(id)).thenReturn(Optional.of(expectedTransaction));

        Transaction retrievedTransaction = transactionService.getById(id);

        assertEquals(expectedTransaction, retrievedTransaction);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldReturnNotFoundGivenAWrongId() {

        Long id = 1L;
        when(transactionRepository.findById(id)).thenReturn(Optional.empty());
        transactionService.getById(id);

    }

    @Test
    public void shouldUpdateChangedFieldsInTransaction() {

        Long id = 1L;

        Transaction existingTransaction = new Transaction();
        existingTransaction.setDate(new Date(2023, 8, 29));
        existingTransaction.setAmount(10.3);
        existingTransaction.setDescription("transaction description");

        Transaction updatedTransaction = new Transaction();
        updatedTransaction.setAmount(12.5);

        when(transactionRepository.findById(id)).thenReturn(Optional.of(existingTransaction));
        when(transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(existingTransaction);

        Transaction actual = transactionService.update(id, updatedTransaction);

        assertNotNull(actual);
        assertEquals(updatedTransaction.getAmount(), actual.getAmount());
        assertEquals(existingTransaction.getDescription(), actual.getDescription());


    }

    @Test
    public void shouldDeleteTransactionGivenId() {
        Long id = 1L;

        Transaction transaction = new Transaction();
        transaction.setId(id);

        when(transactionRepository.findById(id)).thenReturn(Optional.of(transaction));

        transactionService.delete(id);

        verify(transactionRepository, times(1)).delete(transaction);

    }

}
