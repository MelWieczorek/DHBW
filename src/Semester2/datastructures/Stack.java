package Semester2.datastructures;

public class Stack<T>{

    private Node<T> topNode = null;
    private int size = 0;

    public void push(T data){
        topNode = new Node<T>(data, topNode); //hat immer Referenz auf den vorherigen TopNode
        size++;
    }

    public T pop(){
        if (topNode != null){
            T data = topNode.getData();
            topNode = topNode.getLowerNode(); //unterliegender Node wird zum neuen topNode
            size--;
            return data;
        }
        return null;
    }

    public T peek(){
        if (topNode != null){
            return topNode.getData();
        }
        return null;
    }
    public int size(){
        return this.size;
    }


    private class Node<T>{
        private T data;
        private Node<T> lowerNode;

        public Node(T data, Node<T>lowerNode){
            this.data = data;
            this.lowerNode = lowerNode;
        }

        public Node<T> getLowerNode(){
            return this.lowerNode;
        }

        private T getData(){
            return this.data;
        }


    }

}
