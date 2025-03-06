package e3;

public interface MainLogics {
    boolean selectCell(Pair<Integer, Integer> cell);
    boolean hasWon();
    void toggleFlag(Pair<Integer, Integer> cell);
    boolean hasMine(Pair<Integer, Integer> cell);
    boolean hasFlag(Pair<Integer, Integer> cell);
    boolean hasCounter(Pair<Integer, Integer> cell);
    String getValue(Pair<Integer, Integer> cell);
    void addMine(Pair<Integer, Integer> pair);

}
