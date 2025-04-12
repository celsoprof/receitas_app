package br.dev.celso.receitas.controller;

import java.util.List;
import java.util.Optional;

import br.dev.celso.receitas.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.celso.receitas.model.Recipe;
import br.dev.celso.receitas.repository.RecipeRepository;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@PostMapping
	public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
		
		System.out.println("Recipe save called...");
		Recipe recipeOut = recipeRepository.save(recipe);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(recipeOut);
		
	}
	
	@GetMapping
	public ResponseEntity<List<RecipeDTO>> getAll(){
		List<Recipe> recipes = recipeRepository.findAll();
		if (!recipes.isEmpty()){
			List<RecipeDTO> recipeDTOS = recipes.stream().map(RecipeDTO::new).toList();
			return ResponseEntity.status(HttpStatus.OK).body(recipeDTOS);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<RecipeDTO> findById(@PathVariable Long id){
		Optional<Recipe> recipeOptional = recipeRepository.findById(id);
		if (recipeOptional.isPresent()){
			RecipeDTO recipeDTO = new RecipeDTO(recipeOptional.get());
			return ResponseEntity.ok().body(recipeDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
