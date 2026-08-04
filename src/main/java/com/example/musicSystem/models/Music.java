package com.example.musicSystem.models;

import jakarta.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int duration;
    private Long streams;
    private boolean active;

    @ManyToOne
    private Artist artist;

    public Music(){

    }

    public Music(String title, int duration, Long streams){
        if (title.isEmpty()){
            throw new IllegalArgumentException("The title can't be empty.");
        }
        if (duration <= 0){
            throw new IllegalArgumentException("The duration must be greater than 0.");
        }
        if (streams < 0){
            throw new IllegalArgumentException("The streams can't be lower than 0.");
        }
        this.title = title;
        this.duration = duration;
        this.streams = streams;
        this.active = true;
    }

    public void activate(){
        if (active){
            throw new IllegalArgumentException("The music is already active.");
        }
        this.active = true;
    }

    public void deactivate(){
        if (!active){
            throw new IllegalArgumentException("The music is already deactivated.");
        }
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public Long getStreams() {
        return streams;
    }

    public boolean isActive() {
        return active;
    }

    public void setArtist(Artist artists) {
        this.artist = artists;
    }
}
