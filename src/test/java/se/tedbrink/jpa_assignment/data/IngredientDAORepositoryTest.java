package se.tedbrink.jpa_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.tedbrink.jpa_assignment.model.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

class IngredientDAORepositoryTest {


    @Autowired
    IngredientDAORepository ingredientDAORepository;

    @Autowired
    TestEntityManager testEntityManager;

    private Ingredient testIngredient;
    private int testId;


    @BeforeEach
    void setUp() {
        testIngredient = testEntityManager.persist(new Ingredient("test_salt"));
        testId = testIngredient.getIngredientId();
    }


    @Test
    void findById() {

        //Arrange
        Ingredient foundById = null;
        //Act
        foundById = ingredientDAORepository.findById(testId);

        //Assert
        assertNotNull(foundById);
        assertEquals(foundById.getIngredient(), testIngredient.getIngredientId());


    }
/*
    @Test
    void findByIngredient() {

        //Arrange
      Ingredient = null;

        }


        //Act
        found = appUserDAO.findAll();

        //Assert
        assertEquals(2, found.size());


    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }


 */
}