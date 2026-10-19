package org.example.orbech_budgeting_app.model;

public class Category {
    private Long id;
    private String name;
    private double monthlyBudget;

    // Constructor
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
    }

}
