package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany( cascade ={
            CascadeType.REFRESH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY

    )
    private List<RecipeIngredient> recipeIngredient;



    @OneToOne( cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
            @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})

    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    //Convenience Method
    public void addRecipeCategory(RecipeCategory recipeCategory) {

        if (recipeCategory == null) throw new IllegalArgumentException("Not allowed to add null");
        if (categories == null) categories = new ArrayList<>();

        if (!categories.contains(recipeCategory)) {
            categories.add(recipeCategory);
        }
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory) {
        if(categories.contains(recipeCategory)) {
            categories.remove(recipeCategory);
        }
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }





}

    // c. Contains a collection of recipe ingredients. When you remove content from this collection make sure to implement automagical removal of this RecipeIngredient.
    //d. Contains recipe instructions of type RecipeInstruction
    // e. Contains a collection of RecipeCategory.

