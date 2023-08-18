package com.example.coincontrol.repositories;

import com.example.coincontrol.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
