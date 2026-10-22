package org.example.orbech_budgeting_app.repository;

import org.example.orbech_budgeting_app.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTransactionRepository {
    private final Map<Long, Transaction> allTransactions = new HashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    // Create & Update (For JPA)
    public Transaction save(Transaction transaction) {
        if (transaction.getId() == null) {
            long id = nextId.getAndIncrement();
            transaction.setId(id);
        }

        allTransactions.put(transaction.getId(), transaction);
        return transaction;
    }

    // Read
    public List<Transaction> findAll() {
        return new ArrayList<>(allTransactions.values());
    }
    public Optional<Transaction> findById(long id) {
        return Optional.ofNullable(allTransactions.get(id));
    }

    // Delete
    public void deleteById(long id) {
        allTransactions.remove(id);
    }

}
