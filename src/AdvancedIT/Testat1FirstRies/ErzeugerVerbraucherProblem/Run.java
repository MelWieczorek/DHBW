package AdvancedIT.Testat1FirstRies.ErzeugerVerbraucherProblem;

import java.util.concurrent.Semaphore;

public class Run {

    public static void main(String[] args) {
        Semaphore arrival = new Semaphore(1,true);
        Train Lok0 = new Train(0,arrival);
        Train Lok1 = new Train(1,arrival);

        Lok0.start();
        Lok1.start();
    }

}
