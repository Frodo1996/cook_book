package pl.javastart.cookbook.entities;

import jakarta.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int preparationTime;
    private int popularity;
    @ManyToOne
    private Category category;

    public Recipe() {
    }

    public Recipe(String name, String description, int preparationTime, int popularity, Category category) {
        this.name = name;
        this.description = description;
        this.preparationTime = preparationTime;
        this.popularity = popularity;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
