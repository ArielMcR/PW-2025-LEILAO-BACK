package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Domains.Category.Category;
import com.pw.leiloeiro.api.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ResponseAnyDTO> create(@Valid @RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Categoria cadastrada com sucesso", Collections.emptyList()));
    }
    @GetMapping
    public ResponseEntity<ResponseAnyDTO> searchAll(){
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","", categoryService.search()));
    }

    @PutMapping
    public ResponseEntity<ResponseAnyDTO> edit(@RequestBody Category category){
        Category cat = categoryService.update(category);
        if(cat !=null){
            return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Categoria atualizada com sucesso", Collections.emptyList()));
        }
        return  null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseAnyDTO> delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","",Collections.emptyList()));
    }

}
