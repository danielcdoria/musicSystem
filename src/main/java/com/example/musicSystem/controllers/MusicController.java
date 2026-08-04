package com.example.musicSystem.controllers;

import com.example.musicSystem.dtos.musicDtos.MusicRequestDto;
import com.example.musicSystem.dtos.musicDtos.MusicResponseDto;
import com.example.musicSystem.services.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    private final MusicService service;
    public MusicController(MusicService service){
        this.service = service;
    }

    @GetMapping("/Musics")
    public ResponseEntity<List<MusicResponseDto>> list(){
        return ResponseEntity.ok(service.list());
    }

    @PostMapping("/Musics")
    public ResponseEntity<MusicResponseDto> createMusic(@RequestBody MusicRequestDto dto){
        MusicResponseDto music = service.createMusic(dto);
        return ResponseEntity.status(201).body(music);
    }

    @GetMapping("/Musics/{id}")
    public ResponseEntity<MusicResponseDto> searchMusic(@PathVariable Long id){
        MusicResponseDto music = service.searchMusic(id);
        return ResponseEntity.ok(music);
    }

    @PutMapping("/Musics/{id}/activate")
    public ResponseEntity<MusicResponseDto> activateMusic(@PathVariable Long id){
        MusicResponseDto music = service.activateMusic(id);
        return ResponseEntity.ok(music);
    }

    @PutMapping("/Musics/{id}/deactivate")
    public ResponseEntity<MusicResponseDto> deactivateMusic(@PathVariable Long id){
        MusicResponseDto music = service.deactivateMusic(id);
        return ResponseEntity.ok(music);
    }

    @DeleteMapping("/Musics/{id}")
    public ResponseEntity<String> removeMusic(@PathVariable Long id){
        String message = service.removeMusic(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/Musics/{id}/artist")
    public ResponseEntity<List<MusicResponseDto>> searchByArtistId(@PathVariable Long id){
        List<MusicResponseDto> list = service.searchByArtistId(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/Musics/active")
    public ResponseEntity<List<MusicResponseDto>> searchByActive(@RequestParam boolean active){
        List<MusicResponseDto> list = service.searchByActive(active);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/Musics/min-streams")
    public ResponseEntity<List<MusicResponseDto>> searchByMinStreams(@RequestParam Long streams){
        List<MusicResponseDto> list = service.searchByMinStreams(streams);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/Musics/max-duration")
    public ResponseEntity<List<MusicResponseDto>> searchByMaxDuration(@RequestParam int duration){
        List<MusicResponseDto> list = service.searchByMaxDuration(duration);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/Musics/genre")
    public ResponseEntity<List<MusicResponseDto>> searchByGenre(@RequestParam String genre){
        List<MusicResponseDto> list = service.searchByGenre(genre);
        return ResponseEntity.ok(list);
    }

}
