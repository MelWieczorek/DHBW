package Semester2.datastructures;

public class BinaryTree<T> {

    private Node<T> root = null;
    private int size = 0;

    public boolean add(T data){
        Node<T> newNode = new Node<T>(data);

        if(root == null){
            this.root = newNode;
            this.size++;
            return true;
        }

        return add(newNode, root);
    }

    private boolean add(Node<T> newNode, Node<T> currentNode){

        int compareToResult = ((Comparable)currentNode.getData()).compareTo(newNode.getData());

        if(compareToResult > 0) { //current node größer
        //left Side
            if(currentNode.getLeftNode() != null ){
                return add(newNode, currentNode.getLeftNode()); //Rekursion falls bereits Folgeknoten vorhanden ist
            }else {
                currentNode.setLeftNode(newNode);
                this.size++;
                return true;
            }

        } else if(compareToResult < 0){
        //right side
            if(currentNode.getRightNode() != null ){
                return add(newNode, currentNode.getRightNode());
            }else {
                currentNode.setRightNode(newNode);
                this.size++;
                return true;
            }

        }
        return false;
    }

    public int size(){
        return this.size;
    }

    //Traversierung (path traversal)
    public void printInOrder(){

        if(root == null){
            System.out.println("Der Baum ist leer!");
            return;
        }
        System.out.println("");
        System.out.println("In-Order-Ausgabe:");
        printInOrder(root);
    }

    //In-order -->left-->current-->right
    private void printInOrder(Node<T> currentNode){

        if (currentNode.getLeftNode() != null){
            printInOrder(currentNode.getLeftNode()); //gehen immer weiter zum linken Knoten, bis es keinen mehr gibt
        }

        System.out.print(currentNode.getData() + ", ");
        if(currentNode.getRightNode() != null){
            printInOrder(currentNode.getRightNode());
        }

    }

    //pre-order current-left-right
    public void printPreOrder(){

        if(root == null){
            System.out.println("Der Baum ist leer!");
            return;
        }
        System.out.println("");
        System.out.println("Pre-Order-Ausgabe:");
        printPreOrder(root);
    }

    private void printPreOrder(Node<T> currentNode){
        System.out.print(currentNode.getData() + ", "); //--> Unterschied zu InOrder: Erst aktuelles ausgeben, dann nach links, dann nach rechts
        if (currentNode.getLeftNode() != null){
            printPreOrder(currentNode.getLeftNode()); //gehen immer weiter zum linken Knoten, bis es keinen mehr gibt
        }

        if(currentNode.getRightNode() != null){
            printPreOrder(currentNode.getRightNode());
        }

    }

    //post-order left-right-current
    public void printPostOrder(){

        if(root == null){
            System.out.println("Der Baum ist leer!");
            return;
        }
        System.out.println("");
        System.out.println("Post-Order-Ausgabe:");
        printPostOrder(root);
    }

    private void printPostOrder(Node<T> currentNode){

        if (currentNode.getLeftNode() != null){
            printPostOrder(currentNode.getLeftNode()); //gehen immer weiter zum linken Knoten, bis es keinen mehr gibt
        }

        if(currentNode.getRightNode() != null){
            printPostOrder(currentNode.getRightNode());
        }
        System.out.print(currentNode.getData() + ", "); //--> Unterschied zu InOrder/PreOrder: Erst links/rechts, dann current


    }

    private class Node<T>{
        private final T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data){
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        public T getData(){
            return this.data;
        }

        public Node<T> getLeftNode(){
            return this.leftNode;
        }

        public Node<T> getRightNode(){
            return this.rightNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }
    }

}
