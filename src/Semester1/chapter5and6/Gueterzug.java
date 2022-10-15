package Semester1.chapter5and6;

public class Gueterzug {
    private int id;
    private int laenge;
    Zugfuehrer zugfuehrer;
    Gueterwagon gueterwagon;
    Lokomotive lokomotive;


    public Gueterzug(int id, int laenge, Zugfuehrer zugfuehrer, Gueterwagon gueterwagon, Lokomotive lokomotive) {
        this.setId(id);
        this.setLaenge(laenge);
        this.setZugfuehrer(zugfuehrer);
        this.setGueterwagon(gueterwagon);
        this.setLokomotive(lokomotive);
    }

    public Gueterwagon getGueterwagon() {
        return gueterwagon;
    }

    public void setGueterwagon(Gueterwagon gueterwagon) {
        this.gueterwagon = gueterwagon;
    }

    public Lokomotive getLokomotive() {
        return lokomotive;
    }

    public void setLokomotive(Lokomotive lokomotive) {
        this.lokomotive = lokomotive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public Zugfuehrer getZugfuehrer() {
        return zugfuehrer;
    }

    public void setZugfuehrer(Zugfuehrer zugfuehrer) {
        this.zugfuehrer = zugfuehrer;
    }
}
