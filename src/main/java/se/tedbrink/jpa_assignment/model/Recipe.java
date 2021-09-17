package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;


/*
    @ManyToOne(cascade = {      ///////////// TA BORT /////////////////
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_ingredient_id")
    private RecipeIngredient recipeIngredient;
 */

    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
           // @JoinColumn(name = "recipe_instruction_id")

    private RecipeInstruction recipeInstruction;



    @ManyToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
    fetch = FetchType.LAZY)

    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )

    private List<RecipeCategory> recipeCategory;            ////////////////////// KOLLA UPP DENNA
/*
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstructione;

    */
    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe() {
    }
}



    // c. Contains a collection of recipe ingredients. When you remove content from this collection make sure to implement automagical removal of this RecipeIngredient.
    //d. Contains recipe instructions of type RecipeInstruction
    // e. Contains a collection of RecipeCategory.

