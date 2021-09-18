package se.tedbrink.jpa_assignment.data;

import org.springframework.stereotype.Repository;
import se.tedbrink.jpa_assignment.model.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeInstructionDAORepository implements RecipeInstructionDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction findById(String id) {
        return entityManager.find(RecipeInstruction.class, findById(id));
    }

    @Override
    @Transactional
    public Collection<RecipeInstruction> findAll() {
        return entityManager.createQuery("SELECT ri FROM RecipeInstruction ri", RecipeInstruction.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional
    public void delete(String id) {
        entityManager.remove(findById(id));

    }
}
