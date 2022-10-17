package AdvancedIT.Testat1FirstRies.ErzeugerVerbraucherProblem;



import java.util.concurrent.Semaphore;


public class Train extends Thread{

    int id;
    private Semaphore arrival;
    public Train(int id, Semaphore arrival) {
        this.id = id;
        this.arrival = arrival;
    }

    public void run(){
        while (true){
            try {
                System.out.println("lok " + id + " running normally");
                enter();
                System.out.println("lok " + id + " running on critical area");
                sleep((long) Math.random() * 10000000);
                exit();
                sleep((long) Math.random() * 10000000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void enter(){
        try {
            arrival.acquire();
            System.out.println("lok "+id+" has entered");
            sleep((long)Math.random()*10000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void exit(){
        try {
        arrival.release();
        System.out.println("lok "+id+" has exited");
            sleep((long)Math.random()*10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
