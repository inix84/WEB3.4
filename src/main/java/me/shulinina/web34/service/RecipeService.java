package me.shulinina.web34.service;
import me.shulinina.web34.model.Recipe;
public interface RecipeService {
    long addRecipe(Recipe recipe);
    Recipe getRecipe(long id);
    Recipe editRecipe(long id, Recipe recipe);
    boolean deleteRecipe(long id);
    void deleteAllRecipe();
    Recipe getAllRecipe();
}