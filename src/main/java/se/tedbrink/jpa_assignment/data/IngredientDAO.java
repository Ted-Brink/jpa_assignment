package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient findById(int id);
    Ingredient findByIngredient(String ingredient);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(int id);
}
