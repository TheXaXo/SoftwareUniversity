package app.repositories;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<BasicIngredient, Long> {
    Set<BasicIngredient> findAllByNameStartingWith(String letter);

    Set<BasicIngredient> findAllByNameIn(Set<String> names);

    @Transactional
    void deleteAllByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE BasicIngredient b SET b.price = b.price + 0.1 * b.price")
    void increaseAllIngredientsPrice();

    @Modifying
    @Transactional
    @Query("UPDATE BasicIngredient b SET b.price = b.price + 0.1 * b.price WHERE b IN :ingredients")
    void increaseIngredientsPrice(@Param(value = "ingredients") Set<BasicIngredient> ingredients);
}