package view;

import domain.piece.Piece;
import domain.position.File;
import domain.position.Position;
import domain.position.Positions;
import domain.position.Rank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

final class BoardView {

    private static final String EMPTY_SPACE = ".";

    public void printBoard(final Map<Position, Piece> board) {
        Arrays.stream(Rank.values())
                .filter(rank -> !Rank.NOTHING.equals(rank))
                .map(rank -> makeAnRankView(board, rank))
                .forEach(System.out::println);
        System.out.println();
    }

    private String makeAnRankView(final Map<Position, Piece> board, final Rank rank) {
        return Arrays.stream(File.values())
                .filter(file -> !File.NOTHING.equals(file))
                .map(file -> file.getName() + rank.getName())
                .map(position -> makePieceView(board, Positions.from(position)))
                .collect(Collectors.joining());
    }

    private String makePieceView(final Map<Position, Piece> board, final Position position) {
        if (board.containsKey(position)) {
            return convertCaseByTeam(board.get(position));
        }

        return EMPTY_SPACE;
    }

    private String convertCaseByTeam(final Piece piece) {
        if (piece.isBlack()) {
            return piece.getName();
        }

        return piece.getName().toLowerCase();
    }
}
