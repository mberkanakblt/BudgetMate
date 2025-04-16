package com.mehmetberkan.service;

import com.mehmetberkan.dto.request.AddCategoryRequestDto;
import com.mehmetberkan.entity.Category;
import com.mehmetberkan.exception.BudgetMateException;
import com.mehmetberkan.exception.ErrorType;
import com.mehmetberkan.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category addCategoryy(AddCategoryRequestDto dto) {
        Boolean isExists = categoryRepository.existsByName(dto.name());
        if(isExists) throw new BudgetMateException(ErrorType.EXISTED_KATEGORI);
        Category category = Category.builder()
                .name(dto.name())
                .description(dto.description())
                .build();
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryy(Long id) {
        categoryRepository.deleteById(id);
    }
}
