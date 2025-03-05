package e2;

public class MoveExecutorImpl implements MoveExecutor {
    private Position knight;
    private final MoveValidator moveValidator;

    public MoveExecutorImpl(Position knight, MoveValidator moveValidator) {
        this.knight = knight;
        this.moveValidator = moveValidator;
    }

    @Override
    public boolean moveKnight(Position newPos) {
        if (moveValidator.isValidMove(this.knight, newPos)) {
            this.knight = newPos;
            return true;
        }
        return false;
    }

    @Override
    public Position getKnightPosition() {
        return this.knight;
    }
}
