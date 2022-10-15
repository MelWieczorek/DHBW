package Semester2.Klausur;

import java.util.Set;
import java.util.TreeSet;

public class TestKunde {
    public static void main(String[] args) {
        Kunde Klaus = new Kunde("Mustermann","Klaus",4711);
        Kunde Hans = new Kunde("Beispiel","Hans",5180);
        Kunde Hilde = new Kunde("Mustermann","Hilde",4712);
        Kunde Theodor = new Kunde("Vorbild","Theodor",8278);
        Kunde Jimmy = new Kunde("Dummy","Jimmy",1111);

        Set<Kunde> kundenSammlung = new TreeSet<Kunde>();
        kundenSammlung.add(Klaus);
        kundenSammlung.add(Hans);
        kundenSammlung.add(Hilde);
        kundenSammlung.add(Theodor);
        kundenSammlung.add(Jimmy);

        for (Kunde k: kundenSammlung
             ) {
            System.out.println("Nummer" + k.getKundenNummer()+"Name"+k.getName()+"Vorname"+k.getVorname());
        }
        Kunde Theodor2 = new Kunde("Vorbild","Theodor",8278);

        System.out.println(Theodor.equals(Theodor2));

    }





}
