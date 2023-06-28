package pl.javastart.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.cookbook.dto.UserDto;
import pl.javastart.cookbook.entities.User;
import pl.javastart.cookbook.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    String users(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("user", new UserDto());
        return "/users";
    }

    @PostMapping("/users")
    String addUser(UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/users";
    }
}