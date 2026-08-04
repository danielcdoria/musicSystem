package com.example.musicSystem.dtos.artistDtos;

public class ArtistMusicResponseDto {
    private Long id;
    private String title;
    private int duration;
    private Long streams;

    public ArtistMusicResponseDto(Long id,
                                  String title,
                                  int duration,
                                  Long streams){
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.streams = streams;
    }

    public Long getId() {
        return id;
    }

    public Long getStreams() {
        return streams;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }
}
