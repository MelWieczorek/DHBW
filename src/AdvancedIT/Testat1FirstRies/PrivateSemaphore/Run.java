package AdvancedIT.Testat1FirstRies.PrivateSemaphore;


import java.util.concurrent.Semaphore;

public class Run {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1,true);
        Train train0 = new Train(0,mutex);
        Train train1 = new Train(1,mutex);
        Train[] trains = {train0,train1};
        for (Train train : trains){
            train.setTrains(trains);
        }

        train0.start();
        train1.start();
    }

}
