package com.example.musicSystem.dtos.artistDtos;

public class ArtistResponseDto {
    private Long id;
    private String name;
    private String email;
    private String genre;
    private boolean active;

    public ArtistResponseDto(Long id,
                             String name,
                             String email,
                             String genre,
                             boolean active){
        this.id = id;
        this.name = name;
        this.email = email;
        this.genre = genre;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGenre() {
        return genre;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }
}
