package com.example.musicSystem.services;

import com.example.musicSystem.dtos.musicDtos.MusicRequestDto;
import com.example.musicSystem.dtos.musicDtos.MusicResponseDto;
import com.example.musicSystem.models.Artist;
import com.example.musicSystem.models.Music;
import com.example.musicSystem.repositories.ArtistRepository;
import com.example.musicSystem.repositories.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository repository;
    private final ArtistRepository artistRepository;
    public MusicService(MusicRepository repository, ArtistRepository artistRepository){
        this.repository = repository;
        this.artistRepository = artistRepository;
    }

    private Music searchEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No music was found."));
    }

    private MusicResponseDto convertToDto(Music music){
        return new MusicResponseDto(
                music.getId(),
                music.getTitle(),
                music.getDuration(),
                music.getStreams(),
                music.isActive(),
                music.getArtist().getId(),
                music.getArtist().getName(),
                music.getArtist().getEmail()
        );
    }

    public List<MusicResponseDto> list(){
        List<Music> list = repository.findAll();
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public MusicResponseDto createMusic(MusicRequestDto dto){
        if (dto == null){
            throw new IllegalArgumentException("The music can't be empty.");
        }
        Artist artist = artistRepository.findById(dto.getArtistId())
                .orElseThrow(() -> new IllegalArgumentException("No artist was found."));
        Music music = new Music(
                dto.getTitle(),
                dto.getDuration(),
                dto.getStreams()
        );
        music.setArtist(artist);
        repository.save(music);
        return convertToDto(music);
    }

    public MusicResponseDto searchMusic(Long id){
        Music music = searchEntity(id);
        return convertToDto(music);
    }

    public MusicResponseDto activateMusic(Long id){
        Music music = searchEntity(id);
        music.activate();
        repository.save(music);
        return convertToDto(music);
    }

    public MusicResponseDto deactivateMusic(Long id){
        Music music = searchEntity(id);
        music.deactivate();
        repository.save(music);
        return convertToDto(music);
    }

    public String removeMusic(Long id){
        Music music = searchEntity(id);
        repository.delete(music);
        return "The music was removed successfully.";
    }

    public List<MusicResponseDto> searchByArtistId(Long artistId){
        List<Music> list = repository.findByArtistId(artistId);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no music of this artist.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<MusicResponseDto> searchByActive(boolean active){
        List<Music> list = repository.findByActive(active);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There isn't active music.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<MusicResponseDto> searchByMinStreams(Long streams) {
        if (streams == null) {
            throw new IllegalArgumentException("The streams can't be null.");
        }
        List<Music> list = repository.findByStreamsGreaterThanEqual(streams);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no music above this streams");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<MusicResponseDto> searchByMaxDuration(int duration){
        if(duration <= 0){
            throw new IllegalArgumentException("The duration must be above 0.");
        }
        List<Music> list = repository.findByDurationLessThanEqual(duration);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no music under this duration.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<MusicResponseDto> searchByGenre(String genre){
        if (genre.isEmpty()){
            throw new IllegalArgumentException("The genre can't be empty.");
        }
        List<Music> list = repository.findbyArtist_Genre(genre);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no music of this Artist genre.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }
}
