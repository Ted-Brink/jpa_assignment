package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_ingredient_id")
    private RecipeIngredient recipeIngredient;




    // c. Contains a collection of recipe ingredients. When you remove content from this collection make sure to implement automagical removal of this RecipeIngredient.
    //d. Contains recipe instructions of type RecipeInstruction
    // e. Contains a collection of RecipeCategory.
}
