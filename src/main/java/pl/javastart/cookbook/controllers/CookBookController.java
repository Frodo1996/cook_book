package pl.javastart.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.cookbook.dto.RecipeDto;
import pl.javastart.cookbook.services.RecipeService;

import java.util.List;

@Controller
public class CookBookController {

    private final RecipeService recipeService;

    public CookBookController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<RecipeDto> mostPopularList = recipeService.find3MostPopular();
        List<RecipeDto> latest = recipeService.find3Latest();
        model.addAttribute("mostPopularList", mostPopularList);
        model.addAttribute("latest", latest);
        return "home";
    }
}