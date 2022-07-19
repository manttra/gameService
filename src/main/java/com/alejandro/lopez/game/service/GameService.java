package com.alejandro.lopez.game.service;

import com.alejandro.lopez.game.controller.dto.GameResultDto;

public interface GameService {

  /**
   * Play game with the element Id selected by user
   *
   * @param elementId
   * @return gameResultDto
   */
  GameResultDto playGame(int elementId);
}
