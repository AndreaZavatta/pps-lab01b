package e2;

public class GameRulesImpl implements GameRules{
    @Override
    public boolean isKnightCapturingPawn(Position knight, Position pawn) {
        return knight.equals(pawn);
    }
}
