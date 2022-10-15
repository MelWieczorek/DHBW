package Semester2.datastructures;

public class LinkedWordListRun {
    public static void main(String[] args) {
        LinkedWordList myWords = new LinkedWordList();

        myWords.add("aslkdja");
        myWords.add("lkjasdlks");
        myWords.add("JLASKdj");
        myWords.add("a");

        System.out.println("Liste ausgeben: ");
        System.out.println(myWords.contains("a"));
        System.out.println(myWords.size());
        myWords.printWordList();
    }


    }
