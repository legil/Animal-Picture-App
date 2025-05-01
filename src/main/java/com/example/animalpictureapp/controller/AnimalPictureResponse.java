package com.example.animalpictureapp.controller;

public class AnimalPictureResponse {
    private String imageUrl;

    public AnimalPictureResponse(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
