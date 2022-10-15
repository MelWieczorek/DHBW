package Semester2.Swing;

import javax.swing.*;
import java.awt.*;

public class MyFirstUI {
    public static void main(String[] args) {

        JFrame myFirstUI = new JFrame("Mein erstes UI");

        myFirstUI.setLayout(new FlowLayout());

        JLabel uiText = new JLabel("Herzlich Willkommen");
        JButton breakButton = new JButton("Pause starten");

        myFirstUI.add(uiText); //Components ineinander verschachtelbar
        myFirstUI.add(breakButton);
        //myFirstUI.setSize(300,200); //--> setzt Größe manuell
        //myFirstUI.setBounds(100,180,200,300); --> Setzt Ecken manuell
        myFirstUI.pack(); //nimmt gebrauchte Größe
        myFirstUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// --> setzt Schließverhalten fest, standartmäßig läuft Task weiter
        myFirstUI.setVisible(true); //UI sichtbar machen
    }
}
