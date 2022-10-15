package Semester2.Klausur;

public class exercise2 {

    private boolean ledersitze;
    private String farbe;

    public exercise2(boolean bezug, String farbe) throws FalscheParameter{
        if ((bezug ==true &&(farbe == "Schwarz" || farbe == "Weiß"))|| bezug == false) {
            this.ledersitze = bezug;
            this.farbe = farbe;
        }else {throw new FalscheParameter(farbe);}

    }

    public String getFarbe() {
        return farbe;
    }

    public boolean isLedersitze() {
        return ledersitze;
    }
}
