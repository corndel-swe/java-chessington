package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;
import java.util.stream.Collectors;

public class Rook extends AbstractPiece {
  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    return getLateralMoves(from, board).collect(Collectors.toList());
  }

  @Override
  public Rook duplicate() {
    return new Rook(colour);
  }
}
