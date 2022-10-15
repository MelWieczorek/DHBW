package Semester1.chapter5and6;

public class Fracht {
    private int id;
    private int masse;
    Gueterwagon gueterwagon;

    public Fracht(int id, int masse, Gueterwagon gueterwagon) {
        this.setId(id);
        this.setMasse(masse);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasse() {
        return masse;
    }

    public void setMasse(int masse) {
        this.masse = masse;
    }

    public Gueterwagon getGueterwagon() {
        return gueterwagon;
    }

    public void setGueterwagon(Gueterwagon gueterwagon) {
        this.gueterwagon = gueterwagon;
    }
}
