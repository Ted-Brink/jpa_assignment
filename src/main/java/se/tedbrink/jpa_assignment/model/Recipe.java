package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToOne( cascade = {CascadeType.DETACH, CascadeType.REFRESH} )        // Osäker på CascadeType/////
            @JoinColumn(name = "recipe_instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH})   //Osäker på CascadeType //////

    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<RecipeCategory> recipeCategory;            ////////////////////// KOLLA UPP DENNA/////////////

    public Recipe() {
    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategory) {
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategory = recipeCategory;
    }

    // private List<RecipeIngredient> recipeIngredients ;   /// FUNGERAR ICKE ////////////////////

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(List<RecipeCategory> recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getRecipeName(), recipe.getRecipeName()) && Objects.equals(getRecipeInstruction(), recipe.getRecipeInstruction()) && Objects.equals(getRecipeCategory(), recipe.getRecipeCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeName(), getRecipeInstruction(), getRecipeCategory());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategory=" + recipeCategory +
                '}';
    }
}

    // c. Contains a collection of recipe ingredients. When you remove content from this collection make sure to implement automagical removal of this RecipeIngredient.
    //d. Contains recipe instructions of type RecipeInstruction
    // e. Contains a collection of RecipeCategory.

