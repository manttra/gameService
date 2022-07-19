package com.alejandro.lopez.game.model.enums;


import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public enum ElementEnum {

  Stone(0),
  Paper(1),
  Scissors(2);


  private final int elementId;
  private static final Random RANDOM = new Random();

  ElementEnum(int elementId) {
    this.elementId = elementId;
  }

  public int getElementId() {
    return elementId;
  }

  /**
   * @return
   */
  public static ElementEnum getRandomeElement() {
    ElementEnum[] elements = values();
    return elements[RANDOM.nextInt(elements.length)];
  }

  /**
   * @param elementId
   * @return
   */
  public static Optional<ElementEnum> valueOfelementId(int elementId) {
    return Arrays.stream(ElementEnum.values())
        .filter(elementEnum -> elementEnum.elementId == elementId)
        .findFirst();
  }
}
