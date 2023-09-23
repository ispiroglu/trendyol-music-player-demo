package com.example.musicplayer.service;

import com.example.musicplayer.domain.dto.request.CreateSongRequestDto;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.exception.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class SongService {

  private final HashMap<UUID, Song> songHashMap;

  public SongService() {
    this.songHashMap = new HashMap<>();
  }

  public Song getById(UUID id) {
    return Optional.of(songHashMap.get(id)).orElseThrow(NotFoundException::new);
  }

  public Song create(CreateSongRequestDto request) {
    var song = Song.builder()
        .id(UUID.randomUUID())
        .name(request.getName())
        .artist(request.getArtist())
        .duration(request.getDuration())
        .build();
    return songHashMap.put(song.getId(), song);
  }

  public List<Song> getAllSongs() {
    return new ArrayList<>(songHashMap.values());
  }

  public void updateSong(UUID id, CreateSongRequestDto request) {
    var song = getById(id);
    song.setName(request.getName());
    song.setArtist(request.getArtist());
    song.setDuration(request.getDuration());
    songHashMap.put(id, song);
  }

  public void deleteSong(UUID id) {
    var song = getById(id);
    songHashMap.remove(song);
  }
}
