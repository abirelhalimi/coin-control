package com.example.coincontrol.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "transaction")
@SequenceGenerator(name = "TRANSACTION_SQ", sequenceName = "transaction_sequence")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TRANSACTION_SQ")
    private Long id;

    private Date date;
    private Double amount;
    private String description;
    @ManyToOne
    private Account account;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
