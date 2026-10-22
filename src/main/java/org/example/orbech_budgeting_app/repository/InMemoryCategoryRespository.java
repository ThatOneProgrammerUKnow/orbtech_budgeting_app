package org.example.orbech_budgeting_app.repository;

import org.example.orbech_budgeting_app.model.Category;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryCategoryRespository {
    private final Map<Long, Category> allCategories = new HashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    // Create & Update (For JPA)
    public Category save(Category category) {
        if (category.getId() == null) {
            long id = nextId.getAndIncrement();
            category.setId(id);
        }

        allCategories.put(category.getId(), category);
        return category;
    }

    // Read
    public List<Category> findAll() {
        return new ArrayList<>(allCategories.values());
    }
    public Optional<Category> findById(long id) {
        return Optional.ofNullable(allCategories.get(id));
    }


    // Delete
    public void deleteById(long id) {
        allCategories.remove(id);
    }

}
