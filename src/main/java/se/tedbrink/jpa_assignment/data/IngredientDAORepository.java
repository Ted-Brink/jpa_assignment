package se.tedbrink.jpa_assignment.data;

import org.springframework.stereotype.Repository;
import se.tedbrink.jpa_assignment.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class IngredientDAORepository implements IngredientDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return  ingredient;
    }

    @Override
    @Transactional
    public Ingredient findById(int id) {
        return entityManager.find(Ingredient.class, id);
    }

    @Override
    @Transactional
    public Ingredient findByIngredient(String ingredient) {
        return entityManager.find(Ingredient.class, ingredient);
    }

    @Override
    @Transactional
    public Collection<Ingredient> findAll() {
        return entityManager.createQuery("SELECT ingr FROM Ingredient ingr", Ingredient.class).getResultList();
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}