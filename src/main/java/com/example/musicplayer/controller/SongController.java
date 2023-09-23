package com.example.musicplayer.controller;

import com.example.musicplayer.domain.dto.request.CreateSongRequestDto;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.service.SongService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/songs")
public class SongController {
  private final SongService songService;

  public SongController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Song> getSong(@PathVariable UUID id) {
    var song = songService.getById(id);
    return ResponseEntity.ok(song);
  }

  @PostMapping()
  public ResponseEntity<Song> createSong(@RequestBody CreateSongRequestDto request) {
    var song = songService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(song);
  }

  @GetMapping()
  public  ResponseEntity<List<Song>> getAllSongs() {
    var songs = songService.getAllSongs();
    return ResponseEntity.ok(songs);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateSong(@RequestBody CreateSongRequestDto request, @PathVariable UUID id) {
    songService.updateSong(id, request);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSong(@PathVariable UUID id) {
    songService.deleteSong(id);
    return ResponseEntity.noContent().build();
  }
}
