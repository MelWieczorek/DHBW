package Semester1.Probeklausur;

public class Auto {
    private static int autoZaehler;
    private String marke;
    private String kfzKz;

    public Auto(){
        autoZaehler++;
    }
    public Auto(String marke, String kfzKz) {
        this.setkfzKz(kfzKz);
        this.setMarke(marke);
        autoZaehler++;
    }
    public void setMarke( String marke){
        this.marke = marke;
    }
    public void setkfzKz( String kfzKz){
        this.kfzKz = kfzKz;
    }
    public String getMarke() {
        return marke;
    }
    public String getkfzKz() {
        return kfzKz;
    }
}
