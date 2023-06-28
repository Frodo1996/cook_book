package pl.javastart.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entities.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findTop3ByOrderByPopularityDesc();

    List<Recipe> findTop3ByOrderByIdDesc();

    List<Recipe> findAllByCategoryId(Long id);
}
