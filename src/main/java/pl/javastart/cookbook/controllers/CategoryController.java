package pl.javastart.cookbook.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.dto.CategoryDto;
import pl.javastart.cookbook.dto.RecipeDto;
import pl.javastart.cookbook.services.CategoryService;
import pl.javastart.cookbook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final RecipeService recipeService;

    public CategoryController(CategoryService categoryService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

    @GetMapping("/categories")
    String showCategories(Model model) {
        List<CategoryDto> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/category")
    String showSingleCategory(@RequestParam Long id, Model model) {
        CategoryDto category = categoryService.findById(id);
        List<RecipeDto> recipes = recipeService.findAllByCategoryId(id);
        model.addAttribute("category", category);
        model.addAttribute("recipes", recipes);
        return "singleCategory";
    }
}