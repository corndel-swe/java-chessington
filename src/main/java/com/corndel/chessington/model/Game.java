package com.corndel.chessington.model;

import com.corndel.chessington.model.pieces.Piece;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
  private final Board board;

  private PlayerColour currentPlayer = PlayerColour.WHITE;

  private boolean isEnded = false;

  public Game(Board board) {
    this.board = board;
  }

  public Piece pieceAt(int row, int col) {
    return board.get(new Coordinates(row, col));
  }

  @JsonIgnore
  public List<Move> getAllowedMoves(Coordinates from) {
    if (isEnded) {
      return new ArrayList<>();
    }

    Piece piece = board.get(from);
    if (piece == null || piece.getColour() != currentPlayer) {
      return new ArrayList<>();
    }

    return piece.getAllowedMoves(from, board).stream()
        .filter(move -> !turnEndsInCheck(move))
        .collect(Collectors.toList());
  }

  private boolean turnEndsInCheck(Move move) {
    Board trialBoard = board.clone();
    trialBoard.move(move.getFrom(), move.getTo());
    return isInCheck(currentPlayer, trialBoard);
  }

  public void makeMove(Move move) throws InvalidMoveException {
    if (isEnded) {
      throw new InvalidMoveException("Game has ended!");
    }

    Coordinates from = move.getFrom();
    Coordinates to = move.getTo();

    Piece piece = board.get(from);
    if (piece == null) {
      throw new InvalidMoveException(String.format("No piece at %s", from));
    }

    if (piece.getColour() != currentPlayer) {
      throw new InvalidMoveException(
          String.format("Wrong colour piece - it is %s's turn", currentPlayer));
    }

    if (!piece.getAllowedMoves(move.getFrom(), board).contains(move)) {
      throw new InvalidMoveException(
          String.format("Cannot move piece %s from %s to %s", piece, from, to));
    }

    board.move(from, to);

    if (isInCheck(currentPlayer, board)) {
      throw new InvalidMoveException(currentPlayer + " cannot end their move in check!");
    }

    currentPlayer = currentPlayer.getOpposite();
  }

  @JsonIgnore
  public boolean isEnded() {
    return isEnded;
  }

  @JsonIgnore
  public String getResult() {
    return null;
  }

  private static boolean isInCheck(PlayerColour player, Board board) {
    Coordinates playerKingPosition = board.getKingPositionForPlayer(player);
    List<Coordinates> otherPlayerPositions =
        board.getAllPiecePositionsForPlayer(player.getOpposite());

    for (Coordinates opponentPiecePosition : otherPlayerPositions) {
      Piece opponentPiece = board.get(opponentPiecePosition);
      if (opponentPiece
          .getAllowedMoves(opponentPiecePosition, board)
          .contains(new Move(opponentPiecePosition, playerKingPosition))) {
        return true;
      }
    }

    return false;
  }

  @JsonProperty("board_pieces")
  public Piece[][] getBoardPieces() {
    return board.getBoard();
  }

  @JsonProperty("current_player")
  public PlayerColour getCurrentPlayer() {
    return currentPlayer;
  }
}
