package e2;

public class KnightMoveValidator implements MoveValidator {
    public Boolean isValidMove(Position knightPos, Position newPos) {
        int x = Math.abs(newPos.getX() - knightPos.getX());
        int y = Math.abs(newPos.getY() - knightPos.getY());
        return (x == 2 && y == 1) || (x == 1 && y == 2);
    }
}
