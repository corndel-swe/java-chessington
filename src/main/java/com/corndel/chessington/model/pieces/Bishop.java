package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;
import java.util.stream.Collectors;

public class Bishop extends AbstractPiece {
  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    return getDiagonalMoves(from, board).collect(Collectors.toList());
  }

  @Override
  public Bishop duplicate() {
    return new Bishop(colour);
  }
}
