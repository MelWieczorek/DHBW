package Semester2.Swing;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExampleUI extends JFrame {

    private BorderLayoutExampleUI(){
        super("BorderLayoutExampleUI");

        JPanel uiContent = new JPanel();
        uiContent.setLayout(new BorderLayout());

        JPanel centerContentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerContentPanel.add(new JButton("Center"));
        uiContent.add(centerContentPanel, BorderLayout.CENTER); //--> Verschachteln mehrerer Container, um mehrere Layout-Manager zu vereinen
        uiContent.add(new JButton("North"), BorderLayout.NORTH);
        uiContent.add(new JButton("South"), BorderLayout.SOUTH);
        uiContent.add(new JButton("East"), BorderLayout.EAST);
        uiContent.add(new JButton("West"), BorderLayout.WEST);

        this.add(uiContent);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutExampleUI();
    }

}
