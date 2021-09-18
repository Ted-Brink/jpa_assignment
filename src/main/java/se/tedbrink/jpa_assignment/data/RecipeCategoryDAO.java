package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {

   RecipeCategory create(RecipeCategory recipeCategory);
   RecipeCategory findById(int id);
   Collection<RecipeCategory> findAll();
   RecipeCategory update(RecipeCategory recipeCategory);
   void delete(int id);





}
