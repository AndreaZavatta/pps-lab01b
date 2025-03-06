package e3;

import javax.swing.*;
import java.util.Map;

public interface AppLogic extends MainLogics{
    Map<JButton,Pair<Integer,Integer>> getRandomBoardJButton();
}
