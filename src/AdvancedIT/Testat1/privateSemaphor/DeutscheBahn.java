package AdvancedIT.Testat1.privateSemaphor;

import java.util.concurrent.Semaphore;

public class DeutscheBahn {
	enum zustand{ FAHREND, WARTEND, KA };
	
	public static void main(String[] args) {
		Semaphore[] sems = { new Semaphore(0, true), new Semaphore(0,true) };
		Semaphore mutex = new Semaphore(1, true);

		zustand[] zustaende = { zustand.FAHREND, zustand.FAHREND};
		
		Thread lok1 = new Lok(0, sems, mutex, zustaende);
		Thread lok2 = new Lok(1, sems, mutex, zustaende);
		
		lok1.start();
		lok2.start();
	}
}
