package com.alejandro.lopez.game.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ResultEnum {

  Win(0, "User wins"),
  Lost(1, "User Loses"),
  Tie(2, "There has been a tie");

  private final int result;
  private final String description;

  public String getDescription() {
    return description;
  }

  ResultEnum(int result, String description) {
    this.result = result;
    this.description = description;
  }

  /**
   * @param result
   * @return
   */
  public static Optional<ResultEnum> getResultEnumByResult(int result) {
    return Arrays.stream(ResultEnum.values())
        .filter(resultEnum -> resultEnum.result == result)
        .findFirst();
  }


}
