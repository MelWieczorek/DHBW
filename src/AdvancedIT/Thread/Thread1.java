package AdvancedIT.Thread;

public class Thread1 extends Thread {
        private int id ;
        static int counter = 0;// AdvancedIT.Thread ID
        public Thread1( int id ){
                this.id = id; } // Konstruktor
        public void run () {
                try {
                        Thread.sleep( (int) ( Math.random() * 1000 ) );
                } catch (Exception e) {}
                System.out.println( "Hello World (ID = "+ id + ")" );//Hier wird der AdvancedIT.Thread beendet
                counter++;// Wenn der AdvancedIT.Thread beendet wird, wird der Zähler hochgezählt


                if (counter == 9 )
                {
                        System.out.println( "Alle fertig" );
                }


        } // run

        public static void main( String[] args )
        {
                for (int i=1; i<10; i++){
                        Thread t = new Thread1( i );
                        t.start();

                }

        } // main
} // class MyThread1
