package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByName(String name);
}
