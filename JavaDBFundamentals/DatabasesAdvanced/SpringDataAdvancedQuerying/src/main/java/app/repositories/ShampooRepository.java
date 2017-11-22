package app.repositories;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo, Long> {
    Set<BasicShampoo> findAllBySizeOrderByIdAsc(Size size);

    Set<BasicShampoo> findAllBySizeAndLabelOrderByPriceAsc(Size size, Label label);

    Set<BasicShampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    Set<BasicShampoo> findAllByIngredientsIn(Set<BasicIngredient> ingredients);

    @Query("SELECT s FROM BasicShampoo s WHERE s.ingredients.size < :number")
    Set<BasicShampoo> findAllByIngredientsCountLessThan(@Param(value = "number") int number);
}