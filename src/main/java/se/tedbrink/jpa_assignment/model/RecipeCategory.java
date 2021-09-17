package se.tedbrink.jpa_assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;
    //  c. Contains a collection of recipes associated to this RecipeCategory.

 /*   @ManyToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
            fetch = FetchType.LAZY)

    @JoinTable( name = "recipe_recipe_category",

            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns =  @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> receptlista;


  */
}
