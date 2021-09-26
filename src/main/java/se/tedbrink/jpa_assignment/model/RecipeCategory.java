package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;


    @ManyToMany(cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST}, //// Osäker på CascadeType och fetch
            fetch = FetchType.LAZY)

    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
           inverseJoinColumns =  @JoinColumn(name = "recipe_id")
    )
    private  List<Recipe> receptlista = new ArrayList<>();


    public RecipeCategory() {
    }

    public RecipeCategory(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;

    }

    //Convience Method
    public  void addRecipe(Recipe recipe) {
        if(!receptlista.contains(recipe)) {
            receptlista.add(recipe);
        }
    }

    public void removeRecipe(Recipe recipe) {
        if(receptlista.contains(recipe)) {
            receptlista.remove(recipe);
        }
    }










    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getReceptlista() {
        return receptlista;
    }

    public void setReceptlista(List<Recipe> receptlista) {
        this.receptlista = receptlista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCategory)) return false;
        RecipeCategory that = (RecipeCategory) o;
        return getCategoryId() == that.getCategoryId() && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getReceptlista(), that.getReceptlista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategory(), getReceptlista());
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", receptlista=" + receptlista +
                '}';
    }
}