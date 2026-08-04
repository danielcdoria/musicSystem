package com.example.musicSystem.repositories;

import com.example.musicSystem.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByArtistId(Long artistId);
    List<Music> findByActive(boolean active);
    List<Music> findByStreamsGreaterThanEqual(Long streams);
    List<Music> findByDurationLessThanEqual(int duration);
    List<Music> findbyArtist_Genre(String genre);
}
