package Semester1.chapter5and6;

public class Zugfuehrer {
    private String name;
    private String vorname;
    private int id;
    private int gebDat;
    Gueterzug Gueterzug;

    public Zugfuehrer(String name, String vorname, int id, int gebDate) {
        this.setName(name);
        this.setVorname(vorname);
        this.setId(id);
        this.setGebDat(gebDate);
    }

    public Semester1.chapter5and6.Gueterzug getGueterzug() {
        return Gueterzug;
    }

    public void setGueterzug(Semester1.chapter5and6.Gueterzug gueterzug) {
        Gueterzug = gueterzug;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGebDat() {
        return gebDat;
    }

    public void setGebDat(int gebDat) {
        this.gebDat = gebDat;
    }
}
