package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.Category;
import com.example.coincontrol.repositories.CategoryRepository;
import com.example.coincontrol.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        return null;
    }

    @Override
    public Category update(Long id, Category newCategoryData) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
