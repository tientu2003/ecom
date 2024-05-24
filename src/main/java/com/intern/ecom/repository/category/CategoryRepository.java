package com.intern.ecom.repository.category;

import com.intern.ecom.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    public Optional<Category> findByTitle(String title);
}