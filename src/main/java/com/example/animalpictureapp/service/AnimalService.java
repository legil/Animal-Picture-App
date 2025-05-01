package com.example.animalpictureapp.service;

import com.example.animalpictureapp.model.AnimalPicture;
import com.example.animalpictureapp.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.stereotype.Service;


@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
   // private final RestTemplate restTemplate;
    


    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
     
    }

    //validate animal type
    private boolean isValidAnimalType(String animalType) {
        return animalType.equalsIgnoreCase("cat") ||
               animalType.equalsIgnoreCase("dog") ||
               animalType.equalsIgnoreCase("bear");
    }

    // Save an animal picture
    public List<String> savePictures(String animalType, int numberOfPictures) {
        if (!isValidAnimalType(animalType)) {
            throw new IllegalArgumentException("Invalid animal type: " + animalType);
        }

        List<AnimalPicture> animalPictures = new ArrayList<>();
        List<String> imageUrls = new ArrayList<>();

        for (int i = 0; i < numberOfPictures; i++) {
            String imageUrl = fetchImageUrl(animalType);
            if (imageUrl != null) {
                animalPictures.add(new AnimalPicture(animalType, imageUrl));
                imageUrls.add(imageUrl);
            }
        }

        if (!animalPictures.isEmpty()) {
            animalRepository.saveAll(animalPictures);
        }

        return imageUrls;
    }


    

    // Fetch the most recent picture for a given animal type
    public String getLastPicture(String animalType) {
        AnimalPicture animalPicture = animalRepository.findTopByAnimalTypeOrderByIdDesc(animalType);
        if (animalPicture != null) {
            return animalPicture.getImageUrl();
        } else {
            return "No picture found for this animal type";
        }
    }

    // Fetch image URL from the appropriate external API
    private String fetchImageUrl(String animalType) {
        int randomParam = new Random().nextInt(10000); // Add randomness to avoid cached images

        switch (animalType.toLowerCase()) {
            case "cat":
                return "https://cataas.com/cat?width=400&rand=" + randomParam;
            case "dog":
                return "https://placedog.net/400/300?random=" + randomParam;
            case "bear":
                return "https://placebear.com/400/300?" + randomParam;
            default:
                return null;
        }
    }


}
