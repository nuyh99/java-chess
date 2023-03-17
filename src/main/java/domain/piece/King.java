package domain.piece;

import domain.position.Position;

public final class King extends Piece {

    private static final String NAME = "K";
    private static final int DIAGONAL_ONE_STEP = 2;
    private static final int ONE_STEP = 1;

    public King(final Team team) {
        super(NAME, team);
    }

    @Override
    public boolean isMovable(final Position source, final Position destination) {
        if (source.isDiagonal(destination) && source.getDistance(destination) == DIAGONAL_ONE_STEP) {
            return true;
        }

        return source.isStraight(destination) && source.getDistance(destination) == ONE_STEP;
    }
}
