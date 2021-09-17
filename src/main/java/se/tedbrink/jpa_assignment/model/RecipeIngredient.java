package se.tedbrink.jpa_assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;

    private double amount;                      // c. Contains a representation of a measured amount type double.
    private Measurement measurement;            // d. Contains a Measurement that represent the unit.

    // b. Contains a reference to Ingredient
    @OneToOne(cascade = CascadeType.ALL)        // Kolla upp CasedType ////////
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    //  e. Contains a reference to the associated Recipe.
    @OneToOne(cascade = CascadeType.ALL)      // Kolla upp Cascade ///////////
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}





