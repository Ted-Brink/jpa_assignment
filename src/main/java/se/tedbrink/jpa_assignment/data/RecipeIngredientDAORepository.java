package se.tedbrink.jpa_assignment.data;

import org.springframework.stereotype.Repository;
import se.tedbrink.jpa_assignment.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeIngredientDAORepository implements RecipeIngredientDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public RecipeIngredient findById(String id) {
        return entityManager.find(RecipeIngredient.class, id);
    }

    @Transactional
    @Override
    public Collection<RecipeIngredient> findByRecipeIngredient(RecipeIngredient recipeIngredient) {     //// Undra om det är rätt???????///////// FEEEEL
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r JOIN FETCH WHERE  r.ingredient LIKE CONCAT('%', :recipeIngredient, '%') ", RecipeIngredient.class)
                .setParameter("recipeIngredient", recipeIngredient).getResultList();
    }
    @Transactional
    @Override
    public Collection<RecipeIngredient> findAll() {
        return entityManager.createQuery("SELECT recipeIng FROM RecipeIngredient recipeIng", RecipeIngredient.class).getResultList();
    }
    @Transactional
    @Override
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }
    @Transactional
    @Override
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return entityManager.merge(recipeIngredient);
    }
    @Transactional
    @Override
    public void delete(String id) {
        entityManager.remove(findById(id));
    }
}
