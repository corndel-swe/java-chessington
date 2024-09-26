package com.corndel.chessington.model.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class QueenTest {

  private Board board;
  private Queen queen = new Queen(PlayerColour.WHITE);

  @BeforeEach
  public void setup() {
    board = Board.empty();
  }

  @Disabled
  @Test
  public void queenCanMoveLaterally() {
    // Arrange

    // Act

    // Assert

  }

}
