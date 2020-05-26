package com.guineapigsanctuary.demo.service;

import com.guineapigsanctuary.demo.dao.Animaldao;
import com.guineapigsanctuary.demo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {

    private final Animaldao animaldao;

    @Autowired
    public AnimalService(@Qualifier("postgres") Animaldao animaldao) {
        this.animaldao = animaldao;
    }

    public int insertAnimal(Animal animal) {
        return animaldao.insertAnimal(animal);
    }


    public List<Animal> getAllAnimals()  {
        return animaldao.selectAllAnimals();
    }

    public Optional<Animal> getAnimalById(UUID id) {
        return animaldao.selectAnimalById(id);
    }

    public int deleteAnimal(UUID id) {
        return animaldao.deleteAnimalById(id);
    }

    public int updateAnimal(UUID id, Animal newAnimal) {
        return animaldao.updateAnimalById(id, newAnimal);
    }
}
