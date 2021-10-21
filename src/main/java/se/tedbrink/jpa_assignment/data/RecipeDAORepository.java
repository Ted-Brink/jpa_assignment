package se.tedbrink.jpa_assignment.data;

import org.springframework.stereotype.Repository;
import se.tedbrink.jpa_assignment.model.Ingredient;
import se.tedbrink.jpa_assignment.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeDAORepository implements RecipeDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Recipe create(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe findById(int id) {
        return entityManager.find(Recipe.class, id);
    }


    @Override
    @Transactional
            public Collection<Recipe>findByName(String recipeName) {
            return entityManager.createQuery("SELECT r from Recipe r " +
                            "WHERE r.recipeName LIKE CONCAT('%', :recipe_name, '%')", Recipe.class)
                            .setParameter("recipe_name", recipeName).getResultList();
        }


    @Override
    @Transactional
    public Collection<Recipe> findAll() {
        return entityManager.createQuery("SELECT rec FROM Recipe rec", Recipe.class).getResultList();
    }


    @Override
    @Transactional
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
