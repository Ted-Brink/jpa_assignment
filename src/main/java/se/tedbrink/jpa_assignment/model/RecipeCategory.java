package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public RecipeCategory(String category) {        // Vet inte om detta behövs
        this(0,category, new ArrayList<>());
    }

}