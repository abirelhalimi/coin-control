package com.example.coincontrol.models;

import jakarta.persistence.*;

@Entity(name = "category")
@SequenceGenerator(name = "CATEGORY_SQ", sequenceName = "category_sequence")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CATEGORY_SQ")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
