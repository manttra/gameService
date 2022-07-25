package com.alejandro.lopez.game.model;

import java.io.Serializable;

import com.alejandro.lopez.game.model.enums.ElementEnum;

import lombok.Data;

@Data
public class Game implements Serializable {

  private static final long serialVersionUID = 3706257567543924830L;

  public ElementEnum userGame;
  public ElementEnum computerGame;

  public Game(ElementEnum userGame) {
    this.userGame = userGame;
    this.computerGame = ElementEnum.getRandomeElement();
  }

}
