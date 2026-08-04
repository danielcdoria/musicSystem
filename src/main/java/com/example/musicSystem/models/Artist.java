package com.example.musicSystem.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String genre;
    private boolean active;

    @OneToMany (mappedBy = "artist")
    private List<Music> musics;

    public Artist(){

    }

    public Artist(String name, String email, String genre){
        if (name.isEmpty() || email.isEmpty() || genre.isEmpty()){
            throw new IllegalArgumentException("The name, the email and the genre can't be empty.");
        }
        this.name = name;
        this.email = email;
        this.genre = genre;
        this.active = true;
    }

    public void activate(){
        if (active){
            throw new IllegalArgumentException("The artist is already active.");
        }
        this.active = true;
    }

    public void deactivate(){
        if (!active){
            throw new IllegalArgumentException("The artist is already deactivated.");
        }
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public boolean isActive() {
        return active;
    }
}

