package com.example.coincontrol.models;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "BUDGET_SQ", sequenceName = "budget_sequence")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BUDGET_SQ")
    private Long id;

    private Double amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
