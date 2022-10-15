package Semester2.Klausur;

public class FalscheParameter extends Exception{

    public FalscheParameter(String farbe){
        super("Die Farbe" + farbe + "ist für Ledersitze unzulässig");
    }

}
