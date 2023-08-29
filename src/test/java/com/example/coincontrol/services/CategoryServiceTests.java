package com.example.coincontrol.services;

import com.example.coincontrol.models.Category;
import com.example.coincontrol.repositories.CategoryRepository;
import com.example.coincontrol.services.Impl.CategoryServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void shouldCreateANewCategory() {

        Category expectedCategory = new Category();
        expectedCategory.setName("categoryName");

        when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(expectedCategory);

        Category createdCategory = categoryService.add(expectedCategory);

        assertNotNull(createdCategory);
        assertEquals(expectedCategory.getName(), createdCategory.getName());

    }

    @Test
    public void shouldReturnTheCategoryGivenAnId() {

        Long id = 1L;
        Category expectedCategory = new Category();
        expectedCategory.setId(id);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(expectedCategory));

        Category retrievedCategory = categoryService.getById(id);

        assertEquals(expectedCategory, retrievedCategory);

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldReturnNotFoundGivenAWrongId() {

        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        categoryService.getById(id);

    }

    @Test
    public void shouldUpdateChangedFieldsInCategory() {

        Long id = 1L;
        Category existingCategory = new Category();
        existingCategory.setName("existing category name");

        Category updatedCategory = new Category();
        updatedCategory.setName("updated category name");

        when(categoryRepository.findById(id)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(existingCategory);

        Category actual = categoryService.update(id, updatedCategory);

        assertNotNull(actual);
        assertEquals(updatedCategory.getName(), actual.getName());
    }

    @Test
    public void shouldDeleteCategoryGivenId() {
        Long id = 1L;

        Category category = new Category();
        category.setId(id);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        categoryService.delete(id);

        verify(categoryRepository, times(1)).delete(category);

    }
}
