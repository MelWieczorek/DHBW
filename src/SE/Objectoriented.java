package SE;

public class Objectoriented {
    private int numberA;
    private int numberB;
    private int result;

    public Objectoriented(int numberA, int numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public int sum(){
        this.result = this.numberA + this.numberB;
        return result;
    }
}

