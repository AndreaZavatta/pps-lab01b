package e2;


public class LogicsImpl implements Logics {

	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final RandomPosition random;
	private final int size;

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition){
        this.random = new RandomPositionGenerator();
		this.pawn = pawnPosition;
        this.knight = knightPosition;
		this.size = size;
    }

    public LogicsImpl(int size){
		this.random = new RandomPositionGenerator();
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }
    
	private Pair<Integer,Integer> randomEmptyPosition(){
    	return random.generateDifferentFrom(this.size, this.pawn);
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (isPositionOutbound(row, col)) {
			throw new IndexOutOfBoundsException();
		}
		Pair<Integer, Integer> nextPos = new Pair<>(row, col);
		if (isValidKnightMove(this.knight, nextPos)) {
			this.knight = nextPos;
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	private boolean isPositionOutbound(int row, int col) {
		return row < 0 || col < 0 || row >= this.size || col >= this.size;
	}

	private static boolean isValidKnightMove(Pair<Integer, Integer> knightPos, Pair<Integer, Integer> newPos) {
		int x = newPos.getX()-knightPos.getX();
		int y = newPos.getY()-knightPos.getY();
		return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}


}
