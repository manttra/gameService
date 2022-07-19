package com.alejandro.lopez.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.lopez.game.service.GameService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = {"api/v1/"})
public class GameController {

  private static final Logger log = LoggerFactory.getLogger(GameController.class);

  private GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }


  /**
   * Play with the computer sending an elementId
   *
   * @param elementId
   * @return gameResultDto
   */
  @GetMapping(value = "/play")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "500", description = "Server Exception"),
      @ApiResponse(responseCode = "200", description = "OK")})
  public ResponseEntity<Object> playGame(
      @RequestParam() @ApiParam(value = "Element") int elementId) {
    log.info("Element Id choosed by user is {}", elementId);
    return new ResponseEntity<>(gameService.playGame(elementId), HttpStatus.OK);
  }

  /**
   * Check the status of the app
   */
  @GetMapping(value = "/health")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "500", description = "Server Exception"),
      @ApiResponse(responseCode = "200", description = "OK")})
  public ResponseEntity<Object> appHealth() {
    return new ResponseEntity<>(HttpStatus.OK);
  }


}
