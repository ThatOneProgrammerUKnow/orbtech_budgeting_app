package org.example.orbech_budgeting_app.model;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;

import java.time.LocalDate;

@Entity
public class Transaction {
    private Long id;
    private double amount;
    private TransactionType type;
    private Category category;
    private LocalDate date;

    // Constructor
    public Transaction(Long id, double amount, TransactionType type, Category category, LocalDate date) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }

        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
    }


    // Getters and setters
    public Long getId() { return this.id; }
    public double getAmount() { return this.amount; }
    public TransactionType getType() { return this.type; }
    public Category getCategory() { return this.category; }
    public LocalDate getDate() { return this.date; }

    public void setId(Long id) { this.id = id; }
    public void setMonthlyBudget(double monthlyBudget) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }
    }
    public void Type(TransactionType type) { this.type = type; }
    public void Category(Category category) { this.category = category; }
    public void Date(LocalDate date) { this.date = date; }

}
