package org.example.orbech_budgeting_app.service;

import org.example.orbech_budgeting_app.exception.ResourceNotFoundException;
import org.example.orbech_budgeting_app.model.Category;
import org.example.orbech_budgeting_app.repository.InMemoryCategoryRespository;
import org.example.orbech_budgeting_app.repository.JpaCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    // Create
    public Category create(Category category) {
        category.setId(null);
        return jpaCategoryRepository.save(category);
    }

    // Read
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll();
    }
    public Category findById(long id) {
        return jpaCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + " was not found"));
    }

    // Update
    public Category update(long id, Category category) {
        this.findById(id); // Throws exception if category is not found
        category.setId(id);
        return jpaCategoryRepository.save(category);
    }

    // Delete
    public void deleteById(long id) {
        this.findById(id); // Throws exception if category is not found
        jpaCategoryRepository.deleteById(id);
    }

}
