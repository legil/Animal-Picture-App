package com.example.animalpictureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.animalpictureapp.model.AnimalPicture;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalPicture, Long> {

    // Method to find the most recent picture by animal type
    AnimalPicture findTopByAnimalTypeOrderByIdDesc(String animalType);
}
