package org.example.orbech_budgeting_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private Double monthlyBudget;

    // Constructor
    protected Category(){
    }
    public Category(Long id, String name, double monthlyBudget) {
        if (monthlyBudget < 0) {
            throw new IllegalArgumentException("Monthly Budget cannot be less than 0");
        }

        this.id = id;
        this.name = name;
        this.monthlyBudget = monthlyBudget;

    }


    // Getters and setters
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public double getBudget() { return this.monthlyBudget; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMonthlyBudget(double monthlyBudget) {
        if (monthlyBudget < 0) {
            throw new IllegalArgumentException("Monthly Budget cannot be less than 0");
        }
        this.monthlyBudget = monthlyBudget;
    }

}
