package br.dev.celso.receitas.controller;

import br.dev.celso.receitas.dto.IngredientDTO;
import br.dev.celso.receitas.model.Ingredient;
import br.dev.celso.receitas.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable Long id){
        Optional<Ingredient> ingredient =  ingredientRepository.findById(id);
        if (ingredient.isPresent()){
            IngredientDTO dto = new IngredientDTO(ingredient.get());
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
