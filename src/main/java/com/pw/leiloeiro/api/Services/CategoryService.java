package com.pw.leiloeiro.api.Services;

import com.pw.leiloeiro.api.Domains.Category.Category;
import com.pw.leiloeiro.api.Infra.Exception.NotFound;
import com.pw.leiloeiro.api.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){
        Category result = categoryRepository.findByName(category.getName());
        if(result != null){
            return result;
        }
        result = categoryRepository.save(category);
        return result;
    }

    public List<Category> search(){
        return categoryRepository.findAll();
    }

    public Category update(Category category){
        System.out.println(category);
        Category categoriaBanco = buscarPorId(category.getId_category());
        categoriaBanco.setObservation(category.getObservation());
        categoriaBanco.setName(category.getName());
        return categoryRepository.save(categoriaBanco);
    }

    public Category buscarPorId(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFound("Categoria não encontrada para edição"));
    }

    public void delete(Long id){
        Category categoriaBanco = buscarPorId(id);
        categoryRepository.delete(categoriaBanco);
    }

    public List<Category> searchByFilters(String name) {
          if (name != null) {
            return categoryRepository.findByNameContaining(name);
        }
        return categoryRepository.findAll();
    }
}
