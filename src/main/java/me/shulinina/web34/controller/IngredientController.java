package me.shulinina.web34.controller;
import me.shulinina.web34.model.Ingredient;
import me.shulinina.web34.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @PostMapping
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient){  // Добавление ингредиента.
        long id =  ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient>getIngredientById(@PathVariable long id){  //Получение информации об ингредиенте по id.
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
    @GetMapping
    public ResponseEntity<Ingredient> getAllIngredient() {  // Получение полного списка ингредиентов.
        ingredientService.getAll();
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) { //Редактирование ингредиента по id.
        Ingredient n = ingredientService.editIngredient(id, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id) {   //Удаление ингредиента.
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllIngredient() { //Удаление всех ингредиентов
        ingredientService.deleteAllIngredient();
        return ResponseEntity.ok().build();
    }
}