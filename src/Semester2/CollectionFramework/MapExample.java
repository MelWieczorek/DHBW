package Semester2.CollectionFramework;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> colorCodes = new HashMap();
        colorCodes.put(1800, "rot");
        colorCodes.put(2000, "blau");
        colorCodes.put(3000, "grün");
        colorCodes.put(4000, "gelb");
        colorCodes.put(5000, "gelb"); //Doppelte Werte sind erlaubt

        System.out.println("Farbe für Code 2000: " + colorCodes.get(2000));
        System.out.println("Anzahl Farben: " + colorCodes.size());

        colorCodes.remove(3000);
        colorCodes.put(2000, "lila"); //Bei doppelter ID --> Wert wird überschrieben

        System.out.println("Farbe für Code 2000: " + colorCodes.get(2000));
        System.out.println("Anzahl Farben: " + colorCodes.size());

        Set<Integer> colorCodeKeys = colorCodes.keySet(); //Keys in Map als Set organisiert
        for(int colorKey: colorCodeKeys){ //Iteratives Auslesen der gesamten Map
            System.out.println("CurrentColorKey: " + colorKey + "ColorValue: " + colorCodes.get(colorKey));
        }

        Collection<String> colorList = colorCodes.values();
        for (String currentColor : colorList) {
            System.out.println(currentColor);
        }
    }
}
