package com.example.musicSystem.dtos.artistDtos;

import java.util.List;

public class ArtistDetailResponseDto {
    private Long id;
    private String name;
    private String email;
    private String genre;
    private boolean active;
    private List<ArtistMusicResponseDto> musics;

    public ArtistDetailResponseDto(Long id,
                                   String name,
                                   String email,
                                   String genre,
                                   boolean active,
                                   List<ArtistMusicResponseDto> musics){
        this.id = id;
        this.name = name;
        this.email = email;
        this.genre = genre;
        this.active = active;
        this.musics = musics;

    }

    public String getGenre() {
        return genre;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<ArtistMusicResponseDto> getMusics() {
        return musics;
    }

    public boolean isActive() {
        return active;
    }
}
