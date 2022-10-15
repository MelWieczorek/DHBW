package Semester2.Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class LoginScreenExercise extends JFrame {
    private static final String ACTION_COMMAND_OK = "OK";
    private static final String ACTION_COMMAND_CANCEL = "CANCEL";

    private LoginScreenExercise(int x,int y){

        super("Simple Login Screen");

        //Borders
        Border NorthBorder = BorderFactory.createSoftBevelBorder(1);
        Border NorthLeftContentBorder = BorderFactory.createTitledBorder("Verbindung");
        Border NorthRightContentBorder = BorderFactory.createTitledBorder("Dateien");

        //Whole Screen
        JPanel uiContent = new JPanel();
        uiContent.setLayout(new BorderLayout());

            //North Content Panel
            JPanel northContentPanel = new JPanel(new FlowLayout());
            northContentPanel.setBorder(NorthBorder);

            //North Content Panel Left
                JPanel northContentLeftPanel = new JPanel(new GridLayout(5,2));
                northContentLeftPanel.setBorder(NorthLeftContentBorder);

                JPanel User = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    User.add(new JLabel("User:"));
                JPanel UserInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    UserInput.add(new JTextField(4));
                JPanel Password = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Password.add(new JLabel("Passwort:"));
                JPanel PasswordInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    PasswordInput.add(new JTextField(6));
                JPanel Art = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Art.add(new JLabel("Art:"));
                JPanel ArtInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    String comboBoxList[] = {"FTP",""};
                    JComboBox comboBox = new JComboBox(comboBoxList);
                    ArtInput.add(comboBox);

                JPanel Host = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Host.add(new JLabel("Host: "));
                JPanel HostInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    HostInput.add(new JTextField(6));
                JPanel Port = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Port.add(new JLabel("Port:"));
                JPanel PortInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    JTextField PortInputText = new JTextField(3);
                    PortInput.add(PortInputText);

            //North Content Panel Left adding together
                northContentLeftPanel.add(User);
                northContentLeftPanel.add(UserInput);
                northContentLeftPanel.add(Password);
                northContentLeftPanel.add(PasswordInput);
                northContentLeftPanel.add(Art);
                northContentLeftPanel.add(ArtInput);
                northContentLeftPanel.add(Host);
                northContentLeftPanel.add(HostInput);
                northContentLeftPanel.add(Port);
                northContentLeftPanel.add(PortInput);

            //North Content Panel Right
                JPanel northContentRightPanel = new JPanel(new GridLayout(2,2));
                northContentRightPanel.setBorder(NorthRightContentBorder);

                JPanel Source = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Source.add(new JLabel("Quelle:"));
                JPanel SourceInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    SourceInput.add(new JTextField(10));
                JPanel Destination = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Destination.add(new JLabel("Ziel:"));
                JPanel DestinationInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    DestinationInput.add(new JTextField(10));

            //North Content Panel Right adding together
                northContentRightPanel.add(Source);
                northContentRightPanel.add(SourceInput);
                northContentRightPanel.add(Destination);
                northContentRightPanel.add(DestinationInput);

            //North Content Panel adding together
                northContentPanel.add(northContentLeftPanel);
                northContentPanel.add(northContentRightPanel);


        //South Content Panel
        JPanel southContentPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        okButton.setActionCommand(ACTION_COMMAND_OK);
        southContentPanel.add(okButton);
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setActionCommand(ACTION_COMMAND_CANCEL);
        southContentPanel.add(cancelButton);

        //Adding together into Whole Screen
        uiContent.add(northContentPanel, BorderLayout.NORTH);
        uiContent.add(southContentPanel, BorderLayout.SOUTH);

        //Whole Frame Info
        this.add(uiContent);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setBounds(x,y,500,500);
        this.setVisible(true);

        comboBox.addItemListener(new ItemListener() { //Event-Listener for ComboBox
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() ==ItemEvent.SELECTED) { //To only give out selected
                    System.out.println("ItemEvent - Item: " + e.getItem());
                    System.out.println("ItemEvent + ParameterString: " + e.paramString());
                    System.out.println("ItemEvent + StateChange: " + e.getStateChange());
                }
                if (e.getItem().equals("FTP")){ //Event depending on selected option
                    PortInputText.setText("300");
                }
            }
        });

        ActionListener myButtonListener = (ActionEvent e) -> { //ActionListener for Buttons allgemein
            System.out.println(""+e.paramString());
            System.out.println(""+e.getActionCommand());
            System.out.println(""+e.getModifiers());
            if(e.getActionCommand().equals("OK")){ //Action Command holt sich Text von Button oder den explizit gesetzten ActionCommand
            System.out.println("Art: "+ comboBox.getSelectedItem()+ " Port "+PortInputText.getText());
            }
            else if (e.getActionCommand().equals("CANCEL")){
                System.exit(0); //Schließt Fenster
            }
        };

        okButton.addActionListener(myButtonListener);
        cancelButton.addActionListener(myButtonListener);

        MouseListener buttonMouseListener = new MouseListener() { //Events für Mäuse
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) { //Beim drüberhovern
                System.out.println("Entered Button with mouse");
                ((JButton)e.getSource()).setEnabled(false);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Beim weghovern
                System.out.println("Exited Button with mouse");
                ((JButton)e.getSource()).setEnabled(true);
            }
        };

    }

    public static void main(String[] args) {

        //Informationen über Screens erhalten
        GraphicsDevice defaultGraphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); //Nur defaultScreen
        System.out.println("Screen Dimensions: "+defaultGraphicsDevice.getDefaultConfiguration().getBounds());

        GraphicsEnvironment virtualGraphicEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = virtualGraphicEnvironment.getScreenDevices(); //Array mit allen Screens

        int x=0;
        int y=0;
        for (GraphicsDevice screen : screens) {
            System.out.println(screen.getDefaultConfiguration().getBounds());
            x=screen.getDefaultConfiguration().getBounds().x;
            y=screen.getDefaultConfiguration().getBounds().y;
        }

        new LoginScreenExercise(x,y);
    }
}
