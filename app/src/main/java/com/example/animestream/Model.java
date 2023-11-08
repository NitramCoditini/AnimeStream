package com.example.animestream;

public class Model {
    public String imageId;

    public String description;


    public Model() {

    }

    public Model(String imageId, String description) {
        this.imageId = imageId;
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}