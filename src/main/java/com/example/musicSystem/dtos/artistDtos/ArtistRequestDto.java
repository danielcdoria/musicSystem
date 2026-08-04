package com.example.musicSystem.dtos.artistDtos;

public class ArtistRequestDto {
    private String name;
    private String email;
    private String genre;

    public ArtistRequestDto(){

    }

    public String getEmail() {
        return email;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }
}
