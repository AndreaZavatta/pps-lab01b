package e2;

public class BoardValidatorImpl implements BoardValidator{
    private final int size;

    public BoardValidatorImpl(int size) {
        this.size = size;
    }

    @Override
    public boolean isPositionOutbound(int row, int col) {
        return row < 0 || col < 0 || row >= size || col >= size;
    }
}
