package com.example.musicplayer;

import com.example.musicplayer.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity notFoundExceptionHandler(Exception e) {
    return ResponseEntity.status(400).body(e.getMessage());
  }
}

