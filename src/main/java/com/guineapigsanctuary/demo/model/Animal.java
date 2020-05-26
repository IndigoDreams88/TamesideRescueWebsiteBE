package com.guineapigsanctuary.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Animal {

    private final UUID id;
    @NotBlank
    private final String name;
    private final String age;
    @NotBlank
    private final String gender;
    @NotBlank
    private final String species;
    private final String colour;
    private final String breed;
    private final String neutered;
    private final String microChipped;
    private final String healthConditions;
    private final String paired;
    private final String status;
    private final String imgUrl;


    public Animal(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") String age, @JsonProperty("gender") String gender, @JsonProperty("species") String species, @JsonProperty("colour") String colour, @JsonProperty("breed") String breed, @JsonProperty("neutered") String neutered, @JsonProperty("microChipped") String microChipped, @JsonProperty("healthConditions") String healthConditions, @JsonProperty("paired") String paired, @JsonProperty("status") String status,@JsonProperty("imgUrl") String imgUrl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.colour = colour;
        this.breed = breed;
        this.neutered = neutered;
        this.microChipped = microChipped;
        this.healthConditions = healthConditions;
        this.paired = paired;
        this.status = status;
        this.imgUrl = imgUrl;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }


    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getNeutered() {
        return neutered;
    }

    public String getMicroChipped() {
        return microChipped;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public String getPaired() {
        return paired;
    }

    public String getStatus() {
        return status;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
