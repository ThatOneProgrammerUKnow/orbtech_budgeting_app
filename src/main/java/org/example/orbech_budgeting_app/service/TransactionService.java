package org.example.orbech_budgeting_app.service;

import org.example.orbech_budgeting_app.exception.ResourceNotFoundException;
import org.example.orbech_budgeting_app.model.Transaction;
import org.example.orbech_budgeting_app.repository.JpaTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final JpaTransactionRepository jpaTransactionRepository;

    public TransactionService(JpaTransactionRepository jpaTransactionRepository) {
        this.jpaTransactionRepository = jpaTransactionRepository;
    }

    // Create
    public Transaction create(Transaction transaction) {
        transaction.setId(null);
        return jpaTransactionRepository.save(transaction);
    }

    // Read
    public List<Transaction> findAll() {
        return jpaTransactionRepository.findAll();
    }
    public Transaction findById(long id) {
        return jpaTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " was not found"));
    }

    // Update
    public Transaction update(long id, Transaction transaction) {
        this.findById(id); // Throws exception if transaction is not found
        transaction.setId(id);
        return jpaTransactionRepository.save(transaction);
    }

    // Delete
    public void deleteById(long id) {
        this.findById(id); // Throws exception if transaction is not found
        jpaTransactionRepository.deleteById(id);
    }

}
