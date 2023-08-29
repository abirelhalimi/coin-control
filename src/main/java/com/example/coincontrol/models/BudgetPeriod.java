package com.example.coincontrol.models;

import jakarta.persistence.*;

import java.time.Month;
import java.time.Year;

@Entity
@SequenceGenerator(name = "BP_SQ", sequenceName = "bp_sequence")
public class BudgetPeriod {

    @Id
    @GeneratedValue()
    Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Month month;

    @Enumerated(EnumType.STRING)
    private Year year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
