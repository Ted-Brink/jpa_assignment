package se.tedbrink.jpa_assignment.data;

import se.tedbrink.jpa_assignment.model.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {

RecipeInstruction create(RecipeInstruction recipeInstruction);
RecipeInstruction findById(String id);
Collection<RecipeInstruction> findAll();
RecipeInstruction update(RecipeInstruction recipeInstruction);
void delete(String id);
}
