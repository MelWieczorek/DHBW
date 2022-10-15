package Semester2.Klausur;

public class Kunde implements Comparable {

    private String name;
    private String vorname;
    private int kundenNummer;

    public Kunde(String name, String vorname, int kundenNummer) {
        this.name = name;
        this.vorname = vorname;
        this.kundenNummer = kundenNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    @Override
    public int compareTo(Object o) {
        return this.kundenNummer - ((Kunde)o).getKundenNummer();
    }

    @Override
    public boolean equals(Object obj) {
        String o = ((Kunde)obj).getName()+((Kunde)obj).getVorname()+((Kunde)obj).getKundenNummer();
        String t = this.getName()+this.getVorname()+this.getKundenNummer();
        if (o==t){return true;}else{
            return false;
        }
    }
}
