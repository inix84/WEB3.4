package me.shulinina.web34.controller;
import me.shulinina.web34.model.Recipe;
import me.shulinina.web34.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @PostMapping
    public ResponseEntity<Long>addRecipe(@RequestBody Recipe recipe){   //Добавление рецепта.
        long id =  recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recipe>getRecipeById(@PathVariable long id){ //Получение рецепта по id.
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @GetMapping
    public ResponseEntity<Recipe> getAllRecipe() {   //Получение списка всех рецептов.
        recipeService.getAll();
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {//Редактирование рецепта по id.
        Recipe r = recipeService.editRecipe(id, recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {//Удаление рецепта по id.
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllRecipe() {//Удаление всех рецептов
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }
}