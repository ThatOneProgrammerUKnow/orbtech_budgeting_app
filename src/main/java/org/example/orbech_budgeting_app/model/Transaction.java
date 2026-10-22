package org.example.orbech_budgeting_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @PastOrPresent
    private LocalDate date;

    // Constructor
    protected Transaction() {
    }
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
    public void setType(TransactionType type) { this.type = type; }
    public void setCategory(Category category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }

}
