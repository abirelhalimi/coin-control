package com.example.coincontrol.services;

import com.example.coincontrol.models.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction add(Transaction transaction);

    Transaction update(Long id, Transaction newTransactionData);

    void delete(Long id);

    Transaction getById(Long id);

    List<Transaction> getAll();
}
