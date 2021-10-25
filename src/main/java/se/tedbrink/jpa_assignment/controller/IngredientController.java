package se.tedbrink.jpa_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.tedbrink.jpa_assignment.data.IngredientDAO;
import se.tedbrink.jpa_assignment.model.Ingredient;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Controller
public class IngredientController {

    private final IngredientDAO ingredientDao;

    @Autowired
    public IngredientController(IngredientDAO ingredientDao) {
        this.ingredientDao = ingredientDao;
    }


    /////CREATE
    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {           /////////FUNKAR

        // Skapar en ingrediens
        Ingredient createdIngredient = ingredient;

        //Spar den in databasen med hjälp av DAO
        createdIngredient = ingredientDao.create(createdIngredient);

        //skicka tillbaka resultated in en Wrapper av ResponseEntity med en status av "skapad"
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredient);

    }


    /////READ

//    @GetMapping("/ingredients/{id}")
//    public ResponseEntity<Ingredient> findById(@PathVariable("id") Integer ingredientId) {
//        Ingredient foundById = ingredientDao.findById(ingredientId);
//        return ResponseEntity.ok(foundById);
//    }

    @GetMapping ("/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable("id") Integer ingredientId) {
        Optional<Ingredient> optional = Optional.ofNullable(ingredientDao.findById(ingredientId));

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


//    @GetMapping("/ingredients{id}")
//    public ResponseEntity<Ingredient>findById (@PathVariable("id") Integer ingredientId) {
//        Optional<Ingredient> foundIngredient = ingredientDao.stream().filter(ingredient -> ingredient.getIngredientId()
//                .equals(ingredientId)).findFirst();
//
//        Ingredient foundById = ingredientDao.findById(ingredientId);
//        return ResponseEntity.ok(foundIngredient.get());
//    }


//    @GetMapping("/ingredients{specificIngredient}")
//    public ResponseEntity findBySpecificIngredient (@PathVariable("specificIngredient") String ingredient)  {
//        Ingredient foundBySpecificIngredient = ingredientDao.findBySpecificIngredient(ingredient);
//        return ResponseEntity.ok(foundBySpecificIngredient);
//    }

    @GetMapping("/ingredients/specificingredient")
    public ResponseEntity<Ingredient> findBySpecificIngredient(@RequestParam("ingredient") String ingredient) {
        Ingredient foundBySpecificIngredient = ingredientDao.findBySpecificIngredient(ingredient);
        return ResponseEntity.ok(foundBySpecificIngredient);
    }


    @GetMapping("/ingredients")
    public ResponseEntity<Collection<Ingredient>> findAll() {                                   ////////////FUNKAR
        Collection<Ingredient> all = ingredientDao.findAll();
        return ResponseEntity.ok(all);
        //return ResponseEntity.status(HttpStatus.OK).body(all); //fungerar men vet inte om det är rätt.
    }

    // UPDATE
    //Ingredient update(Ingredient ingredient);
    @PutMapping("ingredients/{ingredient}")
    public ResponseEntity<Ingredient> update(@PathVariable("ingredient") @RequestBody Ingredient ingredient) {
        Ingredient updatedIngredient = ingredientDao.update(ingredient);
        return ResponseEntity.ok(updatedIngredient);

        //return ResponseEntity.status(HttpStatus.OK).body(updatedIngredient);

    }

    //DELETE
    //void delete(int id);
    @DeleteMapping("/ingredients/{ingredient}")
    public ResponseEntity<Ingredient> delete(@PathVariable("ingredient") Integer id) {

        if(ingredientDao.findById(id)!=null){
            ingredientDao.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}





