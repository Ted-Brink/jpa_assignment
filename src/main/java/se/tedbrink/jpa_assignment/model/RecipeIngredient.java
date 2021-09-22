package se.tedbrink.jpa_assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;

    private double amount;                      // c. Contains a representation of a measured amount type double.
    private Measurement measurement;            // d. Contains a Measurement that represent the unit.

    // b. Contains a reference to Ingredient
    @ManyToOne(cascade = {                      // RELATION TILL INGREDIENT
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST})             // Kolla upp CascadeType fetchType.EAGER default////////
            private Ingredient ingredient;

    //  e. Contains a reference to the associated Recipe.
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH},      // Kolla upp CascadeType ///////
    fetch = FetchType.LAZY)
    //@JoinColumn(name = "recipe_id", table = "recipe_ingredient")     // Ta bort///////////////////////////
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(String recipeIngredientId, double amount, Measurement measurement, Ingredient ingredient) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.measurement = measurement;
        this.ingredient = ingredient;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient)) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && getMeasurement() == that.getMeasurement() && Objects.equals(getIngredient(), that.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getMeasurement(), getIngredient());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", ingredient=" + ingredient +
                '}';
    }
}





