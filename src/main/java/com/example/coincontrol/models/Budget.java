package com.example.coincontrol.models;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "BUDGET_SQ", sequenceName = "budget_sequence")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BUDGET_SQ")
    private Long id;

    private Double budgetAmount;

    private Double actualAmount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
