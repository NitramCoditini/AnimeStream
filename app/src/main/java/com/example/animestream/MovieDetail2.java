package com.example.animestream;

public class MovieDetail2 {
    public String imageId;

    public String description;

    public String genre;

    public MovieDetail2() {
    }

    public MovieDetail2(String imageId, String description, String genre) {
        this.imageId = imageId;
        this.description = description;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
