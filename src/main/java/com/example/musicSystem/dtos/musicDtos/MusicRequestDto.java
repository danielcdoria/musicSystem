package com.example.musicSystem.dtos.musicDtos;

public class MusicRequestDto {
    private String title;
    private int duration;
    private Long streams;
    private Long artistId;

    public MusicRequestDto(){

    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Long getStreams() {
        return streams;
    }

    public Long getArtistId() {
        return artistId;
    }
}
