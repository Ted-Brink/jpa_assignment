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


    @ManyToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JoinTable( name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns =  @JoinColumn(name = "recipe_id")
    )
    private  List<Recipe> receptlista;


    public RecipeCategory() {           // Protected???
    }

    public RecipeCategory(int categoryId, String category, List<Recipe> receptlista) {
        this.categoryId = categoryId;
        this.category = category;
        this.receptlista = receptlista;
    }
//    public RecipeCategory(String category) {        // Vet inte om detta behövs    /////////////////////////////////////////
//        this(0,category, new ArrayList<>());
//    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
        return Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getReceptlista(), that.getReceptlista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getReceptlista());
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