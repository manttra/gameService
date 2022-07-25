package com.alejandro.lopez.game.controller.dto;

public class GameResultDto {

  public String userElement;
  public String computerElement;
  public String result;
  public String error;

  public GameResultDto(String userGame, String computerGame, String result) {
    this.userElement = userGame;
    this.computerElement = computerGame;
    this.result = result;
  }

  public GameResultDto(String error) {
    this.error = error;
  }

}
