package pl.javastart.cookbook.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.cookbook.dto.RecipeDto;
import pl.javastart.cookbook.entities.Recipe;
import pl.javastart.cookbook.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public void add(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getPreparationTime(),
                recipeDto.getPopularity(),
                recipeDto.getCategory());
        recipeRepository.save(recipe);
    }

    @Transactional
    public void edit(RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(recipeDto.getId()).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setPopularity(recipeDto.getPopularity());
        recipe.setCategory(recipeDto.getCategory());
        recipe.setPreparationTime(recipeDto.getPreparationTime());
        recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<RecipeDto> findAll() {
        List<RecipeDto> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> recipes.add(convertToDto(recipe)));
        return recipes;
    }

    public List<RecipeDto> findAllByCategoryId(Long id) {
        List<RecipeDto> recipes = new ArrayList<>();
        recipeRepository.findAllByCategoryId(id).forEach(recipe -> recipes.add(convertToDto(recipe)));
        return recipes;
    }

    @Transactional
    public void likeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        recipe.setPopularity(recipe.getPopularity() + 1);
        recipeRepository.save(recipe);
    }

    public Optional<RecipeDto> findById(Long id) {
        return recipeRepository.findById(id).map(this::convertToDto);
    }

    public List<RecipeDto> find3MostPopular() {
        return recipeRepository.findTop3ByOrderByPopularityDesc().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }

    public List<RecipeDto> find3Latest() {
        return recipeRepository.findTop3ByOrderByIdDesc().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }

    private RecipeDto convertToDto(Recipe recipe) {
        return new RecipeDto(recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getPreparationTime(),
                recipe.getPopularity(),
                recipe.getCategory());
    }
}