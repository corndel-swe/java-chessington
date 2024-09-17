package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queen extends AbstractPiece {
  public Queen(PlayerColour colour) {
    super(PieceType.QUEEN, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    return Stream.concat(getLateralMoves(from, board), getDiagonalMoves(from, board))
        .collect(Collectors.toList());
  }

  @Override
  public Queen duplicate() {
    return new Queen(colour);
  }
}
