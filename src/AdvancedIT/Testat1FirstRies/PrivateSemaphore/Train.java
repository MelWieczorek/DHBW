package AdvancedIT.Testat1FirstRies.PrivateSemaphore;

import java.util.concurrent.Semaphore;

public class Train extends Thread{
enum zustand{a,b};
    int id;
    private Semaphore privateSemaphore = new Semaphore(0,true);
    private Semaphore mutex;
    private Train[] trains;

    public Train(int id, Semaphore mutex){
        this.id = id;
        this.mutex = mutex;
    }

    public void run(){
        while (true){
            try {
                System.out.println("lok " + id + " running normally");
                enter();
                System.out.println("lok " + id + " running on critical area");
                exit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void enter(){
        try {
            mutex.acquire();
            privateSemaphore.acquire();
            trains[1-id].privateSemaphore.acquire();
            mutex.release();
            System.out.println("lok "+id+" has entered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        try {
            mutex.release();
            privateSemaphore.release();
            trains[1-id].privateSemaphore.release();
            mutex.release();
            System.out.println("lok "+id+" has exited");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }
}
