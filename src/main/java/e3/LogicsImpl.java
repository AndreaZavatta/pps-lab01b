package e3;

import java.util.Map;

public class LogicsImpl implements Logics {

    public LogicsImpl(int size) {
    }

    @Override
    public Map<String, Pair<Integer, Integer>> getRandomBoard() {
        return Map.of();
    }

    @Override
    public boolean selectCell(Pair<Integer, Integer> cell) {
        return false;
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cell) {

    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> cell) {
        return false;
    }

    @Override
    public boolean hasFlag(Pair<Integer, Integer> cell) {
        return false;
    }

    @Override
    public boolean hasCounter(Pair<Integer, Integer> cell) {
        return false;
    }

    @Override
    public String getValue(Pair<Integer, Integer> cell) {
        return "";
    }

    @Override
    public void addMine(Pair<Integer, Integer> pair) {

    }
}
