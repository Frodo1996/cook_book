package pl.javastart.cookbook.services;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.cookbook.dto.CategoryDto;
import pl.javastart.cookbook.entities.Category;
import pl.javastart.cookbook.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAllByOrderByNameDesc().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    private CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(),
                category.getName(),
                category.getDescription(),
                category.getImage());
    }
}
