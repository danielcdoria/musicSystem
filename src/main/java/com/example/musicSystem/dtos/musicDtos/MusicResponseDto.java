package com.example.musicSystem.dtos.musicDtos;

public class MusicResponseDto {
    private Long id;
    private String title;
    private int duration;
    private Long streams;
    private boolean active;
    private Long artistId;
    private String artistName;
    private String artistEmail;

    public MusicResponseDto(Long id,
                            String title,
                            int duration,
                            Long streams,
                            boolean active,
                            Long artistId,
                            String artistName,
                            String artistEmail){
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.streams = streams;
        this.active = active;
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistEmail = artistEmail;
    }

    public Long getArtistId() {
        return artistId;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Long getStreams() {
        return streams;
    }

    public String getArtistEmail() {
        return artistEmail;
    }

    public String getArtistName() {
        return artistName;
    }

    public boolean isActive() {
        return active;
    }
}
