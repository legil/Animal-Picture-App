package com.example.animalpictureapp.controller;

import com.example.animalpictureapp.service.AnimalService;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/animals")

public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // POST: Save pictures
    @PostMapping("/pictures")
    public ResponseEntity<List<String>> savePictures(@RequestParam String animalType, @RequestParam int numberOfPictures) {
        try {
            List<String> urls = animalService.savePictures(animalType, numberOfPictures);  // Return URLs
            return ResponseEntity.ok(urls);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }


    // GET: Fetch the last saved picture of a specific animal type
    @GetMapping("/pictures/last/{animalType}")
    public ResponseEntity<String> getLastPicture(@PathVariable String animalType) {
        try {
            String lastPictureUrl = animalService.getLastPicture(animalType); // Get last picture from DB
            if (lastPictureUrl != null) {
                return ResponseEntity.ok(lastPictureUrl);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pictures found for the animal type");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error fetching the picture");
        }
    }
    
    

    @ExceptionHandler(Exception.class)
    public RedirectView handleException(Exception ex) {
        return new RedirectView("http://localhost:8081/index.html");
    }



}
