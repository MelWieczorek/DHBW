package Semester2.Klausur;

public class TestAutoSitzeException {

    public static void main(String[] args) {

        try{
            exercise2 AutoSitze = new exercise2(true,"Rot");
            System.out.println("Ist Ledersitze? "+AutoSitze.isLedersitze()+" Farbe: "+AutoSitze.getFarbe());

        }catch (FalscheParameter f){
            System.out.println(f.getMessage());
        }
    }

}
