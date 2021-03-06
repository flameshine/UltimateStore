package com.example.app.service;

import java.util.List;

import com.example.app.entity.Category;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Category} entity.
 */

public interface CategoryService {

    List<Category> findAll();

    void save(Category role);

    void deleteById(Long id);
}