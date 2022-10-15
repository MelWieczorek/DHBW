package Semester2.IOStreams;

import java.io.*;
import java.util.ArrayList;

public class PersistPerson {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("klaus", "Müller"));
        personList.add(new Person("Gabi", "Fritz"));
        personList.add(new Person("Hans", "Zeus"));
        personList.add(new Person("Michaela", "Amadeus"));

        File myPersonFile = new File(System.getProperty("user.dir") + File.separator + "persons.txt");

        if (!myPersonFile.exists()){
            try {
                myPersonFile.createNewFile();
            }catch (IOException e){
                return;
            }
        }

        try (
                FileWriter myPersonFileWriter = new FileWriter(myPersonFile)){
            for (Person currentPerson: personList) {
                //manuelle Serialisierung
                myPersonFileWriter.write(currentPerson.getFamilyName()+","+currentPerson.getName()+"\n");
            }
        }catch (IOException e){
            System.out.println("Fehler beim Schreiben der Datei" + e.getMessage());
        }

        ArrayList<Person> personFromFileList = new ArrayList<>();

        try (
                FileReader myPersonFileReader = new FileReader(myPersonFile);
                BufferedReader myPersonFileBufferedReader = new BufferedReader(myPersonFileReader)){
            String line;
            while ((line = myPersonFileBufferedReader.readLine()) !=null){
                System.out.println("Gelesen von PersonFile"+line);
                //manuelle De-serialisierung
                String[] personNames = line.split(",");
                personFromFileList.add(new Person(personNames[1],personNames[0]));
            }
        }catch (IOException e){
            System.out.println("Fehler beim Lesen der Datei" + e.getMessage());
        }
        for (Person person : personFromFileList) {
            System.out.println(person.toString());
        }

        System.out.println("Java-Serializable: ");
        File mySerializablePersonFile = new File(System.getProperty("user.dir") + File.separator + "persons.dat");

        if (!mySerializablePersonFile.exists()){
            try {
                mySerializablePersonFile.createNewFile();
            }catch (IOException e){
                return;
            }
        }

        try(FileOutputStream personFileOutputStream = new FileOutputStream(mySerializablePersonFile);
            ObjectOutputStream personObjectOutputStream = new ObjectOutputStream(personFileOutputStream)) {
            for (Person currentPerson:personList) {
                personObjectOutputStream.writeObject(currentPerson);
            }
        }catch (IOException e){
            System.out.println("Fehler beim Schreiben der Datei" + e.getMessage());
        }

        try (FileInputStream personFileInputStream = new FileInputStream(mySerializablePersonFile);
        ObjectInputStream personObjectInputStream = new ObjectInputStream(personFileInputStream)){
            while (true){
                try {
                    System.out.println(personObjectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            System.out.println("Fehler beim Lesen der Datei" + e.getMessage());
        }
    }
    }

