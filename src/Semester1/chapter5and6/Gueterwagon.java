package Semester1.chapter5and6;

public class Gueterwagon {
    private int id;
    private int kapazitaet;
    private Gueterzug gueterzug;
    private Fracht[] fracht;

    public Gueterwagon(int id, int kapazitaet) {
        this.setId(id);
        this.setKapazitaet(kapazitaet);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public Gueterzug getGueterzug() {
        return gueterzug;
    }

    public void setGueterzug(Gueterzug gueterzug) {
        this.gueterzug = gueterzug;
    }
}
