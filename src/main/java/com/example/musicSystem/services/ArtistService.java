package com.example.musicSystem.services;

import com.example.musicSystem.dtos.artistDtos.ArtistDetailResponseDto;
import com.example.musicSystem.dtos.artistDtos.ArtistMusicResponseDto;
import com.example.musicSystem.dtos.artistDtos.ArtistRequestDto;
import com.example.musicSystem.dtos.artistDtos.ArtistResponseDto;
import com.example.musicSystem.models.Artist;
import com.example.musicSystem.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository repository;
    public ArtistService(ArtistRepository repository){
        this.repository = repository;
    }

    private Artist searchEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No artist was found."));
    }

    private ArtistResponseDto convertToDto(Artist artist){
        return new ArtistResponseDto(
                artist.getId(),
                artist.getName(),
                artist.getEmail(),
                artist.getGenre(),
                artist.isActive()
        );
    }

    private ArtistDetailResponseDto convertDetailToDto(Artist artist){
        List<ArtistMusicResponseDto> musics = artist.getMusics().stream()
                .map(music -> new ArtistMusicResponseDto(
                        music.getId(),
                        music.getTitle(),
                        music.getDuration(),
                        music.getStreams()
                )).toList();
        return new ArtistDetailResponseDto(
                artist.getId(),
                artist.getName(),
                artist.getEmail(),
                artist.getGenre(),
                artist.isActive(),
                musics
        );
    }

    public List<ArtistResponseDto> list(){
        List<Artist> list = repository.findAll();
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public ArtistResponseDto createArtist(ArtistRequestDto dto){
        if (dto == null){
            throw new IllegalArgumentException("The artist can't be null.");
        }
        Artist artist = new Artist(
                dto.getName(),
                dto.getEmail(),
                dto.getGenre()
        );
        repository.save(artist);
        return convertToDto(artist);
    }

    public ArtistResponseDto searchArtist(Long id){
        Artist artist = searchEntity(id);
        return convertToDto(artist);
    }

    public ArtistResponseDto activateArtist(Long id){
        Artist artist = searchEntity(id);
        artist.activate();
        repository.save(artist);
        return convertToDto(artist);
    }

    public ArtistResponseDto deactivateArtist(Long id){
        Artist artist = searchEntity(id);
        artist.deactivate();
        repository.save(artist);
        return convertToDto(artist);
    }

    public String removeArtist(Long id){
        Artist artist = searchEntity(id);
        repository.delete(artist);
        return "The artist was removed successfully!";
    }

    public ArtistDetailResponseDto searchArtistDetail(Long id){
        Artist artist = searchEntity(id);
        return convertDetailToDto(artist);
    }
}
