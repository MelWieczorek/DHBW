package Semester2.datastructures;

public class StackRun {
    public static void main(String[] args) {
        Stack<String> myWordStack = new Stack<>();

        myWordStack.push("Brot");
        myWordStack.push("Butter");
        myWordStack.push("Käse");
        myWordStack.push("Salat");
        myWordStack.push("Butter");
        myWordStack.push("Brot");

        System.out.println("Anzahl Elemente: "+myWordStack.size());
        System.out.println("Aktuell oberstes Element: "+myWordStack.peek());
        while (myWordStack.peek()!=null){
            System.out.println("Entnehmen: "+myWordStack.pop());
        }
        System.out.println("Anzahl Elemente: "+myWordStack.size());
    }


}
