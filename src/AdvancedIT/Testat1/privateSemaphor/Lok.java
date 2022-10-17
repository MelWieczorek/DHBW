package AdvancedIT.Testat1.privateSemaphor;

import java.util.concurrent.Semaphore;

public class Lok extends Thread{
	private int id;
	private Semaphore[] sems;
	private Semaphore mutex;
	DeutscheBahn.zustand[] zustaende;
	public Lok(int id, Semaphore[] sems, Semaphore mutex, DeutscheBahn.zustand[] zustaende) {
		this.id = id;
		this.sems = sems;
		this.mutex = mutex;
		this.zustaende = zustaende;
	}
	
	public void run(){

		while(true) {

			System.out.println("lok " + id + " f�hrt normal");

			enterLok();

			exitLok();


		}

	}

	public void enterLok() {

		try {
			//kritischer Abschnitt: beide Loks arbeiten an den Zust�nden
			mutex.acquire();

			//Wenn die andere Lok den kritischen Abschnitt bef�hrt, wartet die aufrufende Lok
			if(zustaende[1 - id] == DeutscheBahn.zustand.KA) {
				zustaende[id] = DeutscheBahn.zustand.WARTEND;
			//Andernfalls wird der kritische Abschnitt betreten
			}else {
				sems[id].release();
				zustaende[id] = DeutscheBahn.zustand.KA;
			}
			mutex.release();
			sems[id].acquire();
			System.out.println("lok " + id + " auf dem KA");


		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}

	public void exitLok() {

		try {
			//kritischer Abschnitt: beide Loks arbeiten an den Zust�nden
			mutex.acquire();

			//Zustand der Lok wird auf FAHREND gesetzt
			zustaende[id] = DeutscheBahn.zustand.FAHREND;
			System.out.println("lok " + id + " f�hrt wieder normal");

			//wenn die andere Lok wartet, wird diese aufgeweckt, da der kritische Abschnitt nun frei ist
			if(zustaende[1 - id] == DeutscheBahn.zustand.WARTEND) {
				zustaende[1 - id] = DeutscheBahn.zustand.KA;
				sems[1 - id].release();
			}

			mutex.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
