package com.example.musicplayer.domain.dto.request;

import lombok.Data;

@Data
public class CreateSongRequestDto {
  private String name;
  private String artist;
  private Double duration;
}
