package com.example.coincontrol.services;

import com.example.coincontrol.models.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category category);

    Category update(Long id, Category newCategoryData);

    void delete(Long id);

    Category getById(Long id);

    List<Category> getAll();
}
