package Semester2.Swing;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExampleUI extends JFrame {

    private GridLayoutExampleUI(){
        super("GridLayoutExampleUI");

        JPanel uiContent = new JPanel();
        uiContent.setLayout(new GridLayout(2,4));

        uiContent.add(new JLabel("Zelle 1"));
        uiContent.add(new JLabel("Zelle2"));
        uiContent.add(new JButton("Zelle3"));
        uiContent.add(new JButton("Zelle4"));
        uiContent.add(new JLabel("Zelle5"));
        uiContent.add(new JLabel("Zelle6"));
        uiContent.add(new JLabel("Zelle7"));
        uiContent.add(new JLabel("Zelle8"));


        this.add(uiContent);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutExampleUI();
    }

}
