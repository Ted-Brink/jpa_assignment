package se.tedbrink.jpa_assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;
    //private Ingredient ingredient;   ////////////////////////////////////////////////////////

    // b. Contains a reference to Ingredient
     private double amount; // c. Contains a representation of a measured amount type double.
    private Measurement unit; // d. Contains a Measurement that represent the unit.
    //  e. Contains a reference to the associated Recipe.

 /*   @ManyToOne(cascade = {    // Ta bort relation
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")

    private Recipe recipe;


*/
    //  none/many to one relation to Ingredient en viss ingrideiens kan finnas i många recept


}





