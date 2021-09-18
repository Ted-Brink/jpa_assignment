package se.tedbrink.jpa_assignment.data;

import org.springframework.stereotype.Repository;
import se.tedbrink.jpa_assignment.model.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeCategoryDAORepository implements RecipeCategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeCategory create(RecipeCategory recipeCategory) {
        entityManager.persist(recipeCategory);
        return  recipeCategory;
    }

    @Override
    @Transactional
    public RecipeCategory findById(int id) {
        return entityManager.find(RecipeCategory.class, id);
    }

    @Override
    @Transactional
    public Collection<RecipeCategory> findAll() {
        return entityManager.createQuery("SELECT rc FROM RecipeCategory rc", RecipeCategory.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return entityManager.merge(recipeCategory);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
