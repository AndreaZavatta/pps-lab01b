package e3;

import javax.swing.*;
import java.util.Map;

public class AppLogicImpl implements AppLogic {
    public AppLogicImpl(int size){

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
    public Map<JButton, Pair<Integer, Integer>> getRandomBoardJButton() {
        return Map.of();
    }

    @Override
    public void addMine(Pair<Integer, Integer> pair) {

    }
}
