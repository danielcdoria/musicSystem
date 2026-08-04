package com.example.musicSystem.controllers;

import com.example.musicSystem.dtos.artistDtos.ArtistDetailResponseDto;
import com.example.musicSystem.dtos.artistDtos.ArtistRequestDto;
import com.example.musicSystem.dtos.artistDtos.ArtistResponseDto;
import com.example.musicSystem.services.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService service;
    public ArtistController(ArtistService service){
        this.service = service;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistResponseDto>> list(){
        return ResponseEntity.ok(service.list());
    }

    @PostMapping("/artists")
    public ResponseEntity<ArtistResponseDto> createArtist(@RequestBody ArtistRequestDto dto){
        ArtistResponseDto artist = service.createArtist(dto);
        return ResponseEntity.status(201).body(artist);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistResponseDto> searchArtist(@PathVariable Long id){
        ArtistResponseDto artist = service.searchArtist(id);
        return ResponseEntity.ok(artist);
    }

    @PutMapping("/artists/{id}/activate")
    public ResponseEntity<ArtistResponseDto> activateArtist(@PathVariable Long id){
        ArtistResponseDto artist = service.activateArtist(id);
        return ResponseEntity.ok(artist);
    }

    @PutMapping("/artists/{id}/deactivate")
    public ResponseEntity<ArtistResponseDto> deactivateArtist(@PathVariable Long id){
        ArtistResponseDto artist = service.deactivateArtist(id);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<String> removeArtist(@PathVariable Long id){
        String message = service.removeArtist(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/artists/{id}/artistDetails")
    public ResponseEntity<ArtistDetailResponseDto> searchArtistDetails(@PathVariable Long id){
        ArtistDetailResponseDto artist = service.searchArtistDetail(id);
        return ResponseEntity.ok(artist);
    }



}
