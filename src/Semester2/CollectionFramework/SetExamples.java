package Semester2.CollectionFramework;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {

    public static void main(String[] args) {
        Set<String> setOfNames = new TreeSet<String>();

        setOfNames.add("Klaus");
        setOfNames.add("Gabi");
        setOfNames.add("Frida");
        setOfNames.add("Zeus");
        setOfNames.add("Klaus"); //Kann nicht hinzugefügt werden --> keine Duplikate erlaubt
        setOfNames.add("Michael");



        System.out.println("Anzahl Namne: " + setOfNames.size());
        System.out.println("Enthlt Gabi?: " + setOfNames.contains("Gabi"));
        System.out.println("Entferne Michael: " + setOfNames.remove("Michael"));
        System.out.println("Anzahl Namen: " + setOfNames.size());
        //setOfNames.get(0); --> nicht mgl., kein wahlfreier Zugriff

        //Sequentielle Ausgabe mit for-each:
        System.out.println("Sequentielle Ausgabe for-each");
        for (String name: setOfNames
             ) {
            System.out.println(name);
        }
        setOfNames.add("Volker");

        //Sequentielle Ausgabe mit Iterator
        System.out.println("Sequentielle Ausgabe Iterator:");
        Iterator<String> i = setOfNames.iterator();
        while (i.hasNext()){
            String name = i.next();
            System.out.println(name);
        }

        //Set mit eigenen Objekten
        System.out.println("Eigene Objekte verwalten: ");
        Set<FullName> setOfFullNames = new TreeSet<FullName>();

        FullName zeusOne = new FullName("Volker", "Schmidt");
        FullName zeusTwo = new FullName("Volker", "Schmidt");
        System.out.println("ZeusOne=ZeusTwo?: " + zeusOne.equals(zeusTwo));
        //-->kommt false heraus --> vergleicht nicht Inhalt, sondern ob die Objekte gleich sind, nach override des equals kommt true raus
        System.out.println("Hash COde ZeusOne: " + zeusOne.hashCode());
        System.out.println("Hash COde ZeusTwo: " + zeusTwo.hashCode());
        //ohne Überschreiben: unterschiedliche Hash-Codes, trotz gleichem Inhalt --> durch Override kommt gleiches Ergebnis wie bei equals heraus (gleicher Inhalt --> gleicher HashCode)
        setOfFullNames.add(new FullName("Volker", "Schmidt"));
        setOfFullNames.add(new FullName("Gabi", "Michels"));
        setOfFullNames.add(new FullName("Zeus", "Godly"));
        setOfFullNames.add(new FullName("Franz", "Michels"));
        setOfFullNames.add(new FullName("Zeus", "Godly"));
        setOfFullNames.add(new FullName("Anna", "Meier"));
        setOfFullNames.add(zeusOne);
        setOfFullNames.add(zeusTwo); //Trotzdem nur einmal enthalten in Set, weil Duplikat
        for (FullName currentName : setOfFullNames
             ) {
            System.out.println(currentName);
        }

        Set<FullName> fullNameSortedByLength = new TreeSet<>(new SortFullNameBySignCount());
        fullNameSortedByLength.addAll(setOfFullNames); //--> übernimmt alle Elemente aus anderer Collection
        System.out.println("Sortiert nach der Länge der Namen: ");
        for (FullName currentName : fullNameSortedByLength
        ) {
            System.out.println(currentName);
        } //Ergebnis weniger Elemente als eingegeben, da Elemente bei gleicher Länge als identisch gewertet werden und rausgeschmissen werden
    }
}
