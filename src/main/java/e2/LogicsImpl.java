package e2;


public class LogicsImpl implements Logics {

	private final Position pawn;
	private final MoveExecutor moveExecutor;
	private final BoardValidator boardValidator;
	private final RandomPosition positionGenerator;
	private final GameRules gameRules;


	public LogicsImpl(int size, Position pawnPosition, Position knightPosition) {
		this.pawn = pawnPosition;
		this.positionGenerator = new RandomPositionImpl(size);
		this.boardValidator = new BoardValidatorImpl(size);
		this.moveExecutor = new MoveExecutorImpl(knightPosition, new KnightMoveValidator());
		this.gameRules = new GameRulesImpl();
	}

	public LogicsImpl(int size) {
		this.positionGenerator = new RandomPositionImpl(size);
		this.boardValidator = new BoardValidatorImpl(size);
		this.pawn = positionGenerator.generate();
		Position knightPosition = positionGenerator.generateDifferentFrom(this.pawn);
		this.moveExecutor = new MoveExecutorImpl(knightPosition, new KnightMoveValidator());
		this.gameRules = new GameRulesImpl();
	}

	@Override
	public boolean hit(int row, int col) {
		if (boardValidator.isPositionOutbound(row, col)) {
			throw new IndexOutOfBoundsException();
		}

		Position nextPos = new Position(row, col);
		if (moveExecutor.moveKnight(nextPos)) {
			return gameRules.isKnightCapturingPawn(moveExecutor.getKnightPosition(), this.pawn);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return moveExecutor.getKnightPosition().equals(new Position(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Position(row, col));
	}


}
