package e3;

import javax.swing.*;
import java.util.Map;

public class AppLogicImpl implements AppLogic {
    Logics logics;

    public AppLogicImpl(int size){
        this.logics = new LogicsImpl(size);
    }


    @Override
    public boolean selectCell(Pair<Integer, Integer> cell) {
        return logics.selectCell(cell);
    }

    @Override
    public boolean hasWon() {
        return logics.hasWon();
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cell) {
        logics.toggleFlag(cell);
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> cell) {
        return logics.hasMine(cell);
    }

    @Override
    public boolean hasFlag(Pair<Integer, Integer> cell) {
        return logics.hasFlag(cell);
    }

    @Override
    public boolean hasCounter(Pair<Integer, Integer> cell) {
        return logics.hasCounter(cell);
    }

    @Override
    public String getValue(Pair<Integer, Integer> cell) {
        return logics.getValue(cell);
    }

    @Override
    public Map<JButton, Pair<Integer, Integer>> getRandomBoardJButton() {
        return this.convertBoard(logics.getRandomBoard());
    }

    private Map<JButton, Pair<Integer,Integer>> convertBoard(Map<String, Pair<Integer, Integer>> board){
        return null;
    }

    @Override
    public void addMine(Pair<Integer, Integer> pair) {
        logics.addMine(pair);
    }
}
