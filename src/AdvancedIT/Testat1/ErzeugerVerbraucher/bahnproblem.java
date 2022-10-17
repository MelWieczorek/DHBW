package AdvancedIT.Testat1.ErzeugerVerbraucher;

public class bahnproblem {
	//hier werden die beiden Lok-Threads und der Buffer erzeugt
	public static void main(String[] args) {
		
		BoundedBuffer bb = new BoundedBuffer();
		
		Thread Lok0 = new Thread(new Runnable() { 
			public void run() {
				
				String lok = "lok 0";
				
				while (true) {
					bb.enterLok(lok);
					System.out.println(lok + " f�hrt auf dem ka");

					

				 	lok = bb.exitLok();
				 	System.out.println(lok + " f�hrt au�erhalb des ka");
				}
				
			}
		});
		
		Thread Lok1 = new Thread(new Runnable() { 
			public void run() {
				
				String lok = "lok 1";
				
				while (true) {
					
						bb.enterLok(lok);
						System.out.println(lok + " f�hrt auf dem ka");

					 	lok = bb.exitLok();
					 	System.out.println(lok + " f�hrt au�erhalb des ka");

					
					
					
				}
				
			}
		});
		
		Lok0.start();
		Lok1.start();

	}

}
