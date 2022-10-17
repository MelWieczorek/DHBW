package AdvancedIT.Testat1.ErzeugerVerbraucher;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
	//es kann nur eine Bahn auf dem KA fahren, daher ist die L�nge des Buffers gleich eins
	//weiterhin ist es nach dieser Erkenntnis nicht n�tig eine nextfull oder nextfree variable anzugeben, da es in dem Array nur ein Element, mit dem Index 0, geben kann
	private int size = 1;
	private String[] buffer = new String[1];
	private Semaphore mutex = new Semaphore(1, true);
	//full verwaltet die belegten Pl�tze des Buffers
	private Semaphore full = new Semaphore(0, true);
	//empty verwaltet die im Buffer noch freien Pl�tze
	private Semaphore empty = new Semaphore(size, true);
	
	public BoundedBuffer() {
		//es wird nichts �bergeben und muss nichts weiter initialisiert werden
	}
	
	public void enterLok( String lok ) {
		
		try {
			
			//es gibt einen freien Platz weniger im Buffer
			//hier ist der Buffer somit vollkommen ausgelastet, wenn nun ein weiteres .acuire() auf empty aufgerufen wird bevor dieses released wird, muss der aufrufende Thread warten
			empty.acquire();
			//der Mutex wird ben�tigt dass nicht zwei Threads gleichzeitig auf den Buffer zugreifen
			mutex.acquire();
			//die befahrende Lok wird dem Buffer �bergeben
			buffer[0] = lok;

			System.out.println(lok + " betritt den ka");
			
			mutex.release();
			//full wird released, da sich nun ein Element im Buffer befindet und es der exitLok() Methode nun m�glich ist ein Element zu entfernen
			full.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String exitLok() {
		String lok = "";
		try {
			
			//wenn sich ein Element im Buffer befindet kann dieses nun ausgelesen und zur�ckgegeben werden
			//wenn sich keines im Buffer befindet, muss der Aufrufende Thread bei full.acquire() warten
			full.acquire();
			mutex.acquire();
			
			lok = buffer[0];
			
			System.out.println(lok + " gibt den ka frei");
			
			mutex.release();
			//empty wird released, da sich nun ein Element weniger (hier also keines) im Buffer befindet und es der enterLok() Methode nun m�glich ist ein Element hinzuzuf�gen
			empty.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return lok;
		
	}
	
}
