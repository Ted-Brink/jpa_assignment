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
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH})     // Kolla upp CascdeType ////////

    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    //  e. Contains a reference to the associated Recipe.
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})      // Kolla upp CascadeType ///////

    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(String recipeIngredientId, double amount, Measurement measurement, Ingredient ingredient, Recipe recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.measurement = measurement;
        this.ingredient = ingredient;
        this.recipe = recipe;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient)) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getRecipeIngredientId(), that.getRecipeIngredientId()) && getMeasurement() == that.getMeasurement() && Objects.equals(getIngredient(), that.getIngredient()) && Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeIngredientId(), getAmount(), getMeasurement(), getIngredient(), getRecipe());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", ingredient=" + ingredient +
                ", recipe=" + recipe +
                '}';
    }
}





