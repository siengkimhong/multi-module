package com.kimhong.service;

import com.kimhong.repository.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findOne(int id);

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto updateCategory);

    void delete(int id);
}
