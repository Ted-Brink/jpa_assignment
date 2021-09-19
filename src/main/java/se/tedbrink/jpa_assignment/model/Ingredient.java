package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @Column(unique = true)
    private String ingredient;

    public Ingredient() {
    }

    public Ingredient(String ingredient) {

        this.ingredient = ingredient;
    }

    public Ingredient(int ingredientId, String ingredient) {
        this.ingredientId = ingredientId;
        this.ingredient = ingredient;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(getIngredient(), that.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredient());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + ingredientId +
                ", ingredient='" + ingredient + '\'' +
                '}';
    }
}