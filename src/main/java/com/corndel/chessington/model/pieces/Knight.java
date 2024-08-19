package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return knightMoves(from)
                .filter(board::inRange)
                .filter(to -> !containsFriendlyPiece(to, board))
                .map(to -> new Move(from, to))
                .collect(Collectors.toList());
    }

    private Stream<Coordinates> knightMoves(Coordinates from) {
        return Stream.of(
                from.plus(2, 1),
                from.plus(2, -1),
                from.plus(-2, 1),
                from.plus(-2, -1),
                from.plus(1, 2),
                from.plus(-1, 2),
                from.plus(1, -2),
                from.plus(-1, -2)
        );
    }

    @Override
    public Knight duplicate() {
        return new Knight(colour);
    }
}
