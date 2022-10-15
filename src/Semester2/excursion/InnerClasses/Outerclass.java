package Semester2.excursion.InnerClasses;


public class Outerclass {

    public static interface InnerInterface{
        void print(String message);
    }

    //Inner Top Level Class
    //--> statisch --> kann ohne Objektkontext drauf zugegriffen werden
    public  static  class InnerTopLevelClass{
        void print(String message){
            System.out.println(this.getClass().getName() + " - InnerTopLevelClass says: " + message);
        }
    }

    //Inner element class
    //--> wie Attribut der äußeren Klasse nur in Objektkontext zugreifbar
    public class InnerElemetClass{
        void print(String message){
            System.out.println(this.getClass().getName() + " - InnerElemetClass says: " + message);
        }
    }

    //InnerLocalClass
    //--> nur im Kontext einer Methode aufrufbar
    void printFromInnerLocalClass(String message){
        class InnerLocalClass{
            void print(String message){
                System.out.println(this.getClass().getName() + " - InnerLocalClass says: " + message);
            }
        }
        InnerLocalClass myInnerLocalClass = new InnerLocalClass();
        myInnerLocalClass.print(message);
    }

    //InnerAnonymousClass
    //--> gebraucht, wenn Interface an genau dieser Stelle implementiert werden soll, es sich aber nicht lohnt, den Code auszulager, z.B. Testen von Exceptions mit executable-Interface

    void printFromInnerAnonymousClass(String message){
        InnerInterface  myInnerAnonymousClass= new InnerInterface() {
            @Override
            public void print(String message) {
                System.out.println(this.getClass().getName() + " - InnerAnonymousClass says: " + message);
            }
        };
        myInnerAnonymousClass.print(message);
    }

    // Lamda-Funktionen:
    // für Anonyme Klassen wurden Lamda-Funktionen hinzugefügt (aus der Funktionalen Programmierung)
    // --> greifen auf Funtionale Interfaces zu --> Funktioniert ohne Objektkontext
    // Definition: ()->{}
    //In runde Klammern: Übergabeparameter
    //In geschweiften Klammern: Codeblock mit Anweisungen
    //Da Funkktionales Interface --> nur eine Funktion --> muss nicht explizit bei implementierung genannt werden
    void printFromLamdaFunction(String message){
        InnerInterface myLamdaFunction = (String lamdaMessage) -> {
            System.out.println(this.getClass().getName() + " - LamdaFunction says: " + lamdaMessage);
        };
        myLamdaFunction.print(message);

    }

    public static void main(String[] args) {
        String message = "Hello World";
        System.out.println(" - OuterCLass says: " + message);

        Outerclass.InnerTopLevelClass myInnerTopLevelClass = new Outerclass.InnerTopLevelClass();
        myInnerTopLevelClass.print(message);

        Outerclass myOuterclass = new Outerclass();
        InnerElemetClass myInnerElementClass =myOuterclass.new InnerElemetClass();
        myInnerElementClass.print(message);

        myOuterclass.printFromInnerLocalClass(message);

        myOuterclass.printFromInnerAnonymousClass(message);

        myOuterclass.printFromLamdaFunction(message);
    }
}
