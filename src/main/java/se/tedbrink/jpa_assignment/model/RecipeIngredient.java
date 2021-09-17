package se.tedbrink.jpa_assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;

    // b. Contains a reference to Ingredient
     private double amount; // c. Contains a representation of a measured amount type double.
    private Measurement measurement; // d. Contains a Measurement that represent the unit.
    //  e. Contains a reference to the associated Recipe.

    @OneToOne(cascade = CascadeType.ALL)        // Kolla upp CasedType ////////
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @OneToOne(cascade = CascadeType.ALL)      // Kolla upp Cascade ///////////
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

/*
    @ManyToOne(cascade = {    // Ta bort relation
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")


*/



    //  none/many to one relation to Ingredient en viss ingrediens kan finnas i många recept


}





