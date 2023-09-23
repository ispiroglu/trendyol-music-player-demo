package com.example.musicplayer.domain.model;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Playlist {
  private UUID id;
  private List<Song> songs;
  private String name;
}
