package app;

import app.model.ingredients.BasicIngredient;
import app.repositories.IngredientRepository;
import app.repositories.LabelRepository;
import app.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private ShampooRepository shampooRepository;
    private LabelRepository labelRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public ConsoleRunner(ShampooRepository shampooRepository, LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient ingredient = this.ingredientRepository.findOne(1L);
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(ingredient);
        this.ingredientRepository.increaseIngredientsPrice(ingredients);
    }
}