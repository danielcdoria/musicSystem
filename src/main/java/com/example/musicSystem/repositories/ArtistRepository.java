package com.example.musicSystem.repositories;

import com.example.musicSystem.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
