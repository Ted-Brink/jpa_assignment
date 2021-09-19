package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient create(Ingredient ingredient);
    Ingredient findById(int id);
    Ingredient findByIngredient(String ingredient);
    Collection<Ingredient> findAll();
    Ingredient update(Ingredient ingredient);
    void delete(int id);
}
