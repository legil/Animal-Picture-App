package com.example.animalpictureapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimalPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String animalType;
    private String imageUrl; // URL to the image of the animal

    // Default constructor
    public AnimalPicture() {}

    // Constructor with parameters
    public AnimalPicture(String animalType, String imageUrl) {
        this.animalType = animalType;
        this.imageUrl = imageUrl;
    }

    // Getter and setter for animalType
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    // Getter and setter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
