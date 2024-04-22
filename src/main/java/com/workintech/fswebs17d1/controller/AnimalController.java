package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @PostConstruct
    public void init() {
        animals.put(1, new Animal(1, "aslan"));
        System.out.println(animals);
    }

    @GetMapping
    public List<Animal> getAnimal() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal newAnimal) {
        if (animals.containsKey(id)) {
            animals.put(id, newAnimal);
            return newAnimal;
        }
        return null; // veya hata işleme yapılabilir
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }
}
