package me.shulinina.web34.service.impl;
import me.shulinina.web34.model.Recipe;
import me.shulinina.web34.service.RecipeService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.TreeMap;
@Service
public class RecipeServiceImpl implements RecipeService {
    private static final Map<Long, Recipe> recipes = new TreeMap<>();
    private static long lastId = 0;
    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(lastId, recipe);
        return lastId++;
    }
    @Override
    public long getRecipe(Recipe recipe) {
        return 0;
    }
    @Override
    public Recipe getRecipe(long id) {
        return recipes.get(id);
    }
}