package com.alejandro.lopez.game.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandro.lopez.game.controller.dto.GameResultDto;
import com.alejandro.lopez.game.model.enums.ElementEnum;
import com.alejandro.lopez.game.model.enums.ResultEnum;
import com.alejandro.lopez.game.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService {

  private int[][] gameRules;

  @Override
  public GameResultDto playGame(int elementId) {
    GameResultDto result;
    Optional<ElementEnum> elementPlayerOptional = ElementEnum.valueOfelementId(elementId);
    if (elementPlayerOptional.isPresent()) {
      this.intitGameRules();
      ElementEnum elementPlayer = elementPlayerOptional.get();
      ElementEnum elementComputer = ElementEnum.getRandomeElement();
      Optional<ResultEnum> resultEnumOptional = ResultEnum.getResultEnumByResult(
          this.gameRules[elementPlayer.getElementId()][elementComputer.getElementId()]);
      result = resultEnumOptional.map(
              resultEnum -> new GameResultDto(elementPlayer.name(), elementComputer.name(),
                  resultEnum.getDescription()))
          .orElseGet(() -> new GameResultDto("Something went wrong"));
    } else {
      result = new GameResultDto("Please, choose a valid element");
    }

    return result;
  }

  private void intitGameRules() {

     /*             Stone  Paper  Scissors
           Stone      2      1       0
           Paper      0      2       1
           Scissors   1      0       2
     */

    this.gameRules = new int[][]{
        {2, 1, 0},
        {0, 2, 1},
        {1, 0, 2}
    };
  }


}
