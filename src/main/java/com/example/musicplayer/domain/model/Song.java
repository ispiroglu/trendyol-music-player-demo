package com.example.musicplayer.domain.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Song {
  private UUID id;
  private String name;
  private String artist;
  private Double duration;
}
