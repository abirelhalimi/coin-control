package com.example.coincontrol.services.Impl;

import com.example.coincontrol.models.Category;
import com.example.coincontrol.repositories.CategoryRepository;
import com.example.coincontrol.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category newCategoryData) {
        Category existingCategory = getById(id);
        if (newCategoryData.getName() != null) {
            existingCategory.setName(newCategoryData.getName());
        }
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(getById(id));
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("category not found"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
