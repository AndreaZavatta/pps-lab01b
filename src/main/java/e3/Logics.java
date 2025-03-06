package e3;
import javax.swing.*;
import java.util.Map;

public interface Logics extends MainLogics{
    Map<String, Pair<Integer, Integer>> getRandomBoard();
}
