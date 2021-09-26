package se.tedbrink.jpa_assignment.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.tedbrink.jpa_assignment.model.Recipe;


public interface RecipeRepository extends CrudRepository<Recipe, String> {




}
