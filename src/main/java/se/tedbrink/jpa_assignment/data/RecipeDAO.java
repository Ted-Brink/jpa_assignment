package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.Recipe;

import java.util.Collection;

public interface RecipeDAO {

    Recipe create(Recipe recipe);
    Recipe findById(int id);
    Collection<Recipe> findAll();
    Recipe update(Recipe recipe);
    void delete(int id);
}