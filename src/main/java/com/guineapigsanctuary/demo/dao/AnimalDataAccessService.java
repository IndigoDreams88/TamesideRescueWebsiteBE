package com.guineapigsanctuary.demo.dao;

import com.guineapigsanctuary.demo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class AnimalDataAccessService implements Animaldao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnimalDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertAnimal(UUID id, Animal animal) {
        String sql = "INSERT INTO animal (id, name, age, gender, species, colour, breed, neutered, microChipped, healthConditions, paired, status, imgUrl) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int newAnimal = jdbcTemplate.update(sql, id, animal.getName(), animal.getAge(), animal.getGender(), animal.getSpecies(), animal.getColour(), animal.getBreed(), animal.getNeutered(), animal.getMicroChipped(), animal.getHealthConditions(), animal.getPaired(), animal.getStatus(), animal.getImgUrl());
        return 0;
    }

    @Override
    public List<Animal> selectAllAnimals() {
        String sql = "SELECT * FROM animal";
        List<Animal> animals = jdbcTemplate.query(sql, (resultSet , i) -> {
            return new Animal(UUID.fromString(resultSet.getString("id")), resultSet.getString("name"), resultSet.getString("age"), resultSet.getString("gender"), resultSet.getString("species"), resultSet.getString("colour"), resultSet.getString("breed"), resultSet.getString("neutered"), resultSet.getString("microChipped"), resultSet.getString("healthConditions"), resultSet.getString("paired"), resultSet.getString("status"), resultSet.getString("imgUrl"));
        });
        return animals;
    }

    @Override
    public Optional<Animal> selectAnimalById(UUID id) {
        String sql = "SELECT * FROM animal WHERE id = ?";
        Animal animal = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet , i) -> {
            return new Animal(UUID.fromString(resultSet.getString("id")), resultSet.getString("name"), resultSet.getString("age"), resultSet.getString("gender"), resultSet.getString("species"), resultSet.getString("colour"), resultSet.getString("breed"), resultSet.getString("neutered"), resultSet.getString("microChipped"), resultSet.getString("healthConditions"), resultSet.getString("paired"), resultSet.getString("status"), resultSet.getString("imgUrl"));
        });
        return Optional.ofNullable(animal);
    }

    @Override
    public int deleteAnimalById(UUID id) {
        String sql = "DELETE FROM animal WHERE id = ?";
        int deletedAnimal = jdbcTemplate.update(sql, new Object[]{id});
        return deletedAnimal;
    }

    @Override
    public int updateAnimalById(UUID id, Animal animal) {
        String sql = "UPDATE animal SET name = ?, age = ?, gender = ?, species = ?, colour = ?, breed = ?, neutered = ?, microChipped = ?, healthConditions = ?, paired = ?, status = ?, imgUrl = ? WHERE id = ?";
        int newAnimal = jdbcTemplate.update(sql, animal.getName(), animal.getAge(), animal.getGender(), animal.getSpecies(), animal.getColour(), animal.getBreed(), animal.getNeutered(), animal.getMicroChipped(), animal.getHealthConditions(), animal.getPaired(), animal.getStatus(), animal.getImgUrl(), id);
        return newAnimal;    }
}
