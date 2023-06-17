package pl.javastart.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByNameDesc();
}
