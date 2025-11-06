package com.example.zoomanagement.controller;

import com.example.zoomanagement.entity.Animal;
import com.example.zoomanagement.service.AnimalService;
import com.example.zoomanagement.service.HabitatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final AnimalService animalService;
    private final HabitatService habitatService;

    public WebController(AnimalService animalService, HabitatService habitatService) {
        this.animalService = animalService;
        this.habitatService = habitatService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Zoo Management System");
        return "index";
    }

    @GetMapping("/animals")
    public String viewAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animals";
    }

    @GetMapping("/add-animal")
    public String showAddAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("habitats", habitatService.getAllHabitats());
        return "add-animal";
    }

    @PostMapping("/animals")
    public String addAnimal(@ModelAttribute Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }
}
