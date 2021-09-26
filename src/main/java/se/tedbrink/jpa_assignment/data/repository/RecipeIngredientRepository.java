package se.tedbrink.jpa_assignment.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.tedbrink.jpa_assignment.model.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {






  //  @Query("Select i FROM Ingredient i JOIN FETCH i.recipeIngredient AS ")


}
