package br.dev.celso.receitas.controller;

import br.dev.celso.receitas.dto.CategoryDTO;
import br.dev.celso.receitas.model.Category;
import br.dev.celso.receitas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        System.out.println("Listando as categorias...");
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()){
            CategoryDTO categoryDTO = new CategoryDTO(categoryOptional.get());
            return ResponseEntity.ok().body(categoryDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
