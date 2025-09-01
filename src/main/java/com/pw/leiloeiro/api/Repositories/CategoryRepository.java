package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByName(String name);

    List<Category> findByNameContaining(String name);
    List<Category> findByObservationContaining(String observation);
    List<Category> findByNameContainingAndObservationContaining(String name, String observation);
}
