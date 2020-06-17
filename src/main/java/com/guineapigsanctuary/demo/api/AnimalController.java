package com.guineapigsanctuary.demo.api;

import com.guineapigsanctuary.demo.model.Animal;
import com.guineapigsanctuary.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@CrossOrigin("https://guineapig-sanctuary.herokuapp.com/")
@RequestMapping("api/v1/animal")
@RestController
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @PostMapping
    public void addAnimal(@Valid @NotNull @RequestBody Animal animal) {
        animalService.insertAnimal(animal);
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
       return animalService.getAllAnimals();
    }

    @GetMapping(path="/{id}")
    public Animal getAnimalbyId(@PathVariable("id") UUID id) {
       return  animalService.getAnimalById(id)
                .orElse(null);
    }


    @DeleteMapping(path="/{id}")
    public void deleteAnimalById(@PathVariable("id") UUID id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping(path="/{id}")
    public void updateAnimal(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Animal animalToUpdate) {
        animalService.updateAnimal(id, animalToUpdate);
    }
}
