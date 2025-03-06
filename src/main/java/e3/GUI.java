package e3;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private Map<JButton,Pair<Integer,Integer>> buttons;
    private final AppLogic appLogic;


    public GUI(int size, int numberOfMines) {
        this.appLogic = new AppLogicImpl(size);
        this.buttons = this.appLogic.getRandomBoardJButton();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);

            boolean aMineWasFound = appLogic.selectCell(pos);
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = appLogic.hasWon(); // call the logic here to ask if there is victory
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    appLogic.toggleFlag(pos);
                    // call the logic here to put/remove a flag
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            if(appLogic.hasMine(entry.getValue())){
                entry.getKey().setText("*");
                entry.getKey().setEnabled(false);
            }
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            if(appLogic.hasCounter(entry.getValue())){
                entry.getKey().setText(appLogic.getValue(entry.getValue()));
            }
            if(appLogic.hasFlag(entry.getValue())){
                entry.getKey().setText("F");
            }
            // call the logic here
            // if this button is a cell with counter, put the number
            // if this button has a flag, put the flag
    	}
    }
    
}
