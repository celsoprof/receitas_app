package br.dev.celso.receitas.controller;

import java.util.List;
import java.util.Optional;

import br.dev.celso.receitas.dto.Recipe2DTO;
import br.dev.celso.receitas.dto.RecipeDTO;
import br.dev.celso.receitas.service.RecipeService;
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

	@Autowired
	private RecipeService recipeService;

	// Teste com o novo DTO
	@PostMapping
	public ResponseEntity<Recipe2DTO> save(@RequestBody Recipe2DTO recipe2DTO) {

		System.out.println("Recipe save called...");
		Recipe2DTO recipeOut = recipeService.save(recipe2DTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(recipeOut);

	}

//	@PostMapping
//	public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
//
//		System.out.println("Recipe save called...");
//		Recipe recipeOut = recipeRepository.save(recipe);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(recipeOut);
//
//	}

	// Teste com o novo DTO
	@GetMapping
	public ResponseEntity<List<Recipe2DTO>> getAll(){
		List<Recipe2DTO> recipe2DTOS = recipeService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(recipe2DTOS);
	}
	
//	@GetMapping
//	public ResponseEntity<List<RecipeDTO>> getAll(){
//		List<Recipe> recipes = recipeRepository.findAll();
//		if (!recipes.isEmpty()){
//			List<RecipeDTO> recipeDTOS = recipes.stream().map(RecipeDTO::new).toList();
//			return ResponseEntity.status(HttpStatus.OK).body(recipeDTOS);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//
//	}

	// Teste com o novo DTO
	@GetMapping("/{id}")
	public ResponseEntity<Recipe2DTO> findById(@PathVariable Long id){
		Recipe2DTO recipe2DTO = recipeService.findById(id);
		if (recipe2DTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(recipe2DTO);
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<RecipeDTO> findById(@PathVariable Long id){
//		Optional<Recipe> recipeOptional = recipeRepository.findById(id);
//		if (recipeOptional.isPresent()){
//			RecipeDTO recipeDTO = new RecipeDTO(recipeOptional.get());
//			return ResponseEntity.ok().body(recipeDTO);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
}
