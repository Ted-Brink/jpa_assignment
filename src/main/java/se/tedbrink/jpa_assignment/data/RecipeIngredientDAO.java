package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.Ingredient;
import se.tedbrink.jpa_assignment.model.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO {

    RecipeIngredient findById(String id);
    Collection<RecipeIngredient> findByRecipeIngredient(RecipeIngredient recipeIngredient);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient create(RecipeIngredient recipeIngredient);
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    void delete(String id);









}
