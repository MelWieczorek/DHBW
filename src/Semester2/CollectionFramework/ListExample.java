package Semester2.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

        List<String> myNameList = new ArrayList();
        List Generic = new ArrayList<String>(); //Kann Liste Datentyp festlegen
        myNameList.add("Klaus");
        myNameList.add("Fritz");
        myNameList.add("Hans-Peter");
        myNameList.add("Klaus");
        myNameList.add("Gabi");
        myNameList.add("Frida");
        //myNameList.add(1);

        System.out.println("Name Index 2:"+myNameList.get(2));
        System.out.println("Enthält Fritz?"+myNameList.contains("Fritz"));
        System.out.println("Anzahl Namen" + myNameList.size());

        for (int i = 0; i < myNameList.size(); i++){
            System.out.println(myNameList.get(i));
        }

        //entfernen von Objekten us Array-List
        myNameList.remove(0);
        System.out.println("Enthält Klaus?"+myNameList.contains("Klaus"));
        //myNameList.remove("Klaus");
        System.out.println("Anzahl Namen: "+myNameList.size());

        //sequenzieller Zugriff
        System.out.println("sequenzieller Zugriff mit for-each:");
        for (String myName : myNameList) {
            System.out.println(myName);
        }

        //Sequentieller Zugriff mit Iterator
        // Standard-Methode zum Zugriff
        System.out.println("sequentieller Zugriff mit Iterator");
        Iterator<String> i = myNameList.iterator();
        while (i.hasNext()){
            String name = i.next();
            if (name.equals("Klaus")){
                i.remove(); //entfernen geht, hinzufügen nicht mgl. (externe Modifikationen verboten)
            }
            System.out.println("Aktueller Name: " + name);
        }

        //Wrapper-Klasse
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(42);  //<-- Auto-Boxing von Int --> Integer
        //numbers.add(new Integer(42)); //deprecated
        numbers.add(Integer.valueOf(42));

        Integer myIntObject = numbers.get(0);
        int myNumber = numbers.get(0); //<-- Auto-Unboxing von Integer zu Int

        List<FullName> fullNameList = new ArrayList<>();
        fullNameList.add(new FullName("Klaus", "Müller"));
        fullNameList.add(new FullName("Gabi", "Schmidt"));
        fullNameList.add(new FullName("Gisela", "Friedhelm"));
        fullNameList.add(new FullName("Klaus", "Müller")); //--> Duplikate möglich in Liste (GGsatz zu Sets)
        System.out.println("Full Name List Augabe: ");
        for(FullName currentFullName : fullNameList){
            System.out.println(currentFullName);
        }

        //Sortieren von Listen: Sortiert Listen nach bestimmter Ornung, kann auch im Nachhinein umsortiert werden(Sortierungen mit Comparator implementiert), anders als in Set aber Elemente, bei denen im Comparator der Wert 0 rauskommt, werden dann als gleich gewertet aber trotzdem in Liste enthalten
        fullNameList.sort(new SortFullNameBySignCount()); //Sortiert Liste nach Comparator
        System.out.println("Full Name List  sorted by SignCount");
        for(FullName currentFullName : fullNameList){
            System.out.println(currentFullName);
        }

        Collections.sort(fullNameList); //Sortiert Liste nach natürlicher Ordnung(mit Comparable implementiert in Objekttyp)
        System.out.println("Full Name List  sorted by Comparator");
        for(FullName currentFullName : fullNameList){
            System.out.println(currentFullName);
        }

        //Sortierung der Liste inline Deklariert mit Lamda-Funktion --> keine eigene Klasse notwendig
        System.out.println("FullNameList Ausgabe sortiert nach Differenz der Länge von Vor-und Nachnamen");
        Collections.sort(fullNameList, (firstFullName ,secondFullName) -> {
            int signCountDifferenceFirstFullName = firstFullName.getFamily_name().length() - firstFullName.getName().length();
            int signCountDifferenceSecondFullName = secondFullName.getFamily_name().length() - secondFullName.getName().length();
            return signCountDifferenceFirstFullName - signCountDifferenceSecondFullName;
        });
        for(FullName currentFullName : fullNameList){
            System.out.println(currentFullName);
        }
    }
}
