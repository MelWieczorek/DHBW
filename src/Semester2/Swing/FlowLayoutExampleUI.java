package Semester2.Swing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExampleUI extends JFrame {

    private FlowLayoutExampleUI(){
        super("Flow Layout Example UI");

        JPanel uiContent = new JPanel();
        uiContent.setLayout(new FlowLayout());

        uiContent.add(new JLabel("Hello World"));
        uiContent.add(new JLabel("Wann ist endlich wieder Pause?"));
        uiContent.add(new JButton("Jetzt"));
        uiContent.add(new JButton("Später"));

        this.add(uiContent);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExampleUI();
    }

}
