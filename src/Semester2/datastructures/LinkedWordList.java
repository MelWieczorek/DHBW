package Semester2.datastructures;

public class LinkedWordList {

    private WordNode firstWordNode = null;
    private int size = 0;

    public void add(String word){
        WordNode newWordNode = new WordNode(word);
        size++;
        if (firstWordNode == null){
            //List is empty
            firstWordNode = newWordNode;
            return;
        }

        WordNode currentWordNode = firstWordNode;
        while (currentWordNode.getNextWordNote() != null){
            currentWordNode = currentWordNode.getNextWordNote();
        }

        currentWordNode.setNextWordNote(newWordNode);
    }

    public boolean contains(String word){
        WordNode currentWordNode = firstWordNode;
        while (currentWordNode.getNextWordNote() != null){
            if(currentWordNode.getWord() == word){
                return true;
            }
            currentWordNode = currentWordNode.getNextWordNote();
        }
        if(currentWordNode.getWord() == word){
            return true;
        }
        else {return false;}
    }

   /* public int size(){
        int counter=0;
        WordNode currentWordNode = firstWordNode;
        while (currentWordNode.getNextWordNote() != null){
            counter++;
            currentWordNode = currentWordNode.getNextWordNote();
        }
        counter++;
        return counter;
    }*/
    //Schnellere Laufzeit als durchzuiterieren
    public int size(){
        return this.size;
    }

    public void printWordList(){
        WordNode currentWordNode = firstWordNode;
        System.out.println("PrintWordList: ");
        while (currentWordNode.getNextWordNote() != null){
            System.out.println(currentWordNode.getWord());
            currentWordNode = currentWordNode.getNextWordNote();
        }
        System.out.println(currentWordNode.getWord());
    }
    public boolean remove(String word){
        if (firstWordNode != null) {
            if (firstWordNode.getWord().equals(word)) {
                firstWordNode = firstWordNode.getNextWordNote();
                size--;
                return true;
            }
            WordNode currentNode = firstWordNode;
            while (currentNode.getNextWordNote() != null) {
                if (currentNode.getNextWordNote().getWord().equals(word)) {
                    currentNode.setNextWordNote(currentNode.getNextWordNote().getNextWordNote()); //Aktuelle next Word node auf übernächste setzten
                    size--;
                    return true;
                }
                currentNode = currentNode.getNextWordNote();
            }
        }
            return false;
        }




    private class WordNode{
        private String word;
        private WordNode nextWordNote;

        public WordNode(String Word){
            this.word = Word;
            this.nextWordNote = null;
        }

        public void setNextWordNote(WordNode nextWordNote){
            this.nextWordNote = nextWordNote;
        }

        public WordNode getNextWordNote(){
            return this.nextWordNote;
        }

        public String getWord(){
            return this.word;
        }
    }
}
