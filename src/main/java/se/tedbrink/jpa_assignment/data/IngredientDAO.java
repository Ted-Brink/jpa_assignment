package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient create(Ingredient ingredient); //ok
    Ingredient findById(int id);
    Ingredient findBySpecificIngredient(String ingredient);

    Collection<Ingredient>findByIngredient(String ingredient);        ////////// Funkar inte
    Collection<Ingredient> findAll();
    Ingredient update(Ingredient ingredient);
    void delete(int id);
}
