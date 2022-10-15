package Semester2.IOStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class FileSystemAccess {
    public static void main(String[] args) {
        File[] drives = File.listRoots();
        for (File drive: drives) {
            System.out.println(drive.getPath() + "exists: " + drive.exists());
            System.out.println("exists: " + drive.exists());
        }
        File[] rootList = File.listRoots();
        for (File root: rootList) {
            System.out.println("Pfad: "+ root.getPath());
            System.out.println("exists: " + root.exists());
            System.out.println("Lesezugriff: "+root.canRead());
            System.out.println("Schreibzugriff: "+root.canWrite());
        }

            //File anyFile = new File("d:\\Mel"); --> doppelter Backslash wegen Escape-Sequenz
        System.out.println("-----------------------------------------------");
        System.out.println("System Properties in Java");
        Properties systemProperties = System.getProperties();
        Set systemPropertiesKey = systemProperties.keySet();
        for (Object key: systemPropertiesKey) {
            System.out.println(key + ": "+ systemProperties.get(key));
        }
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Ausgabe aller Files aus user.dir");
        File userDir = new File(System.getProperty("user.dir"));
        System.out.println("name: "+userDir.getName());
        System.out.println("Pfad: "+userDir.getPath());
        System.out.println("Ist Verzeichnis: "+userDir.isDirectory());
        System.out.println("Existiert: "+userDir.exists());
        System.out.println("Ist Datei: "+userDir.isFile());
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Inhalt von: "+userDir.getName() + ":");

        listDirectoryAndContent(userDir);

        String pathString = System.getProperty("user.dir") + File.separator + "myDirectory";
        String pathRenamedString = System.getProperty("user.dir") + File.separator + "myRenamedDirectory";

        System.out.println(pathString);
        File myDirectory = new File(pathString);
        File myRenamedDirectory = new File(pathRenamedString);
        System.out.println("Existiert: "+myDirectory.exists()); //Existiert noch nicht
        if (!myDirectory.exists()){
            myDirectory.mkdir(); //Creates new directory
            System.out.println(" Existiert: " + myDirectory.exists());
        }
        if (myDirectory.exists() && !myRenamedDirectory.exists()){
            myDirectory.renameTo(myRenamedDirectory);
            System.out.println(myDirectory.getName() + "existiert: "+myDirectory.exists());
            System.out.println(myRenamedDirectory.getName() + "existiert: "+myRenamedDirectory.exists());
        }

        File myFile = new File(myRenamedDirectory.getPath() + File.separator+ "myFile.txt");

        if (!myFile.exists()){
            try {
                System.out.println("Vor Anlegen: "+" Existiert: " + myFile.exists());
                myFile.createNewFile();
                System.out.println("Nach Anlegen: "+" Existiert: " + myFile.exists());
            }catch (IOException e){
                System.out.println("Anlegen der Datei fehlgeschlagen: ");
                System.out.println(e.getMessage());
            }
        }

        //Input
        System.out.println("-----------------------------------------------");
        System.out.println("Einlesen von Daten über System.in");
        System.out.println("Geben einen Text ein: ");
        byte[] input = new byte[255];
        try {
            System.in.read(input,0,255);
        }catch (IOException e){
            System.out.println("Fehler bei der Eingabe" + e.getMessage());
        }
        System.out.println(input);
        System.out.println(new String(input));

        System.out.println("-----------------------------------------------");
        System.out.println("Einlesen von Daten über System.in(Char)");
        InputStreamReader systemInReader = new InputStreamReader(System.in);
        BufferedReader systemInBufferedReader = new BufferedReader(systemInReader);

        String inputString = "";
        ArrayList<String> inputTextLines = new ArrayList<>();
        System.out.println("-----------------------------------------------");
        System.out.println("Gebe einen Text ein (Ausgabe mit exit): ");
        while (true){
            try {
                inputString = systemInBufferedReader.readLine();
                if (inputString.equals("exit")){
                    break;
                }
                System.out.println(inputString);
                inputTextLines.add(inputString);
            }catch (IOException e){
                System.out.println("Fehler bei der Eingabe" + e.getMessage());
            }
        }
        System.out.println("Vollständiger Text: ");
        for (String line : inputTextLines) {
            System.out.println(line);
        }
        FileWriter myTextFileWriter = null;
        try {
            myTextFileWriter = new FileWriter(myFile);

            for (String line : inputTextLines) {
                myTextFileWriter.write(line + "\n"); //\n für Zeilenumbruch
            }
        }catch (IOException e){
            System.out.println("Fehler beim Schreiben der Datei" + e.getMessage());
        }finally {
            try {
                myTextFileWriter.close();
            }catch (IOException e){
                System.out.println("Fehler beim Schließen der Datei" + e.getMessage());
            }
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Auslesen aus Datei: ");
        try (
            FileReader myTextFileReader = new FileReader(myFile);
            BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){
            String line;
            while ((line = myTextFileBufferedReader.readLine()) !=null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Fehler beim Lesen der Datei" + e.getMessage());
        }
    }


    private static void listDirectoryAndContent(File currentDirectory){
        File[] currentDirectoryContent = currentDirectory.listFiles(); //Ruft Liste aller Files auf
        for (File currentFile: currentDirectoryContent) {
            if (currentFile.isDirectory()){
                listDirectoryAndContent(currentFile); //Rekursiver Aufruf
            }else if (currentFile.isFile()){
                System.out.println("File: ");
                System.out.println("Name: " + currentFile.getName());
                System.out.println("Lesezugriff: "+ currentFile.canRead());
                System.out.println("Schreibzugriff: " + currentFile.canWrite());
                System.out.println("Length: "+currentFile.length()+ "Byte");
            }
        }
    };
}
