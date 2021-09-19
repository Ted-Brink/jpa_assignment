package se.tedbrink.jpa_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.tedbrink.jpa_assignment.model.Ingredient;

@SpringBootApplication
public class JpaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssignmentApplication.class, args);
    }
}
