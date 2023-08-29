package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.Transaction;
import com.example.coincontrol.repositories.TransactionRepository;
import com.example.coincontrol.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction add(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Long id, Transaction newTransactionData) {

        Transaction existingTransaction = getById(id);
        if (newTransactionData.getBudgetPeriod() != null)  {
            existingTransaction.setBudgetPeriod(newTransactionData.getBudgetPeriod());
        }
        if (newTransactionData.getAmount() != null)  {
            existingTransaction.setAmount(newTransactionData.getAmount());
        }
        if (newTransactionData.getDate() != null)  {
            existingTransaction.setDate(newTransactionData.getDate());
        }
        if (newTransactionData.getCategory() != null)  {
            existingTransaction.setCategory(newTransactionData.getCategory());
        }
        if (newTransactionData.getDescription() != null)  {
            existingTransaction.setDescription(newTransactionData.getDescription());
        }
        return transactionRepository.save(existingTransaction);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(getById(id));
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("transaction not found"));
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}
