package com.mehmetberkan.repository;

import com.mehmetberkan.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Boolean existsByName(String name);
}
