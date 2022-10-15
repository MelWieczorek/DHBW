package Semester2.algorithms;

public class selectionSort {

    public static void main(String[] args) {

        int[] toSort = {70,90,30,50,100,60,40,20,10,80};

        selectionSort(toSort);
        printArray(toSort);
    }

    public static int[] selectionSort(int[] numbers){
        long startTime = System.nanoTime();
        int sortedMarker = numbers.length-1;

        while (sortedMarker>0){
           int maxPos = 0;
           for (int i =1;i<sortedMarker;i++){
               if (numbers[i]>numbers[maxPos]){
                   maxPos = i;
               }
           }
           swap(numbers,sortedMarker,maxPos);
            sortedMarker--;
        }

        long stopTime = System.nanoTime();
        System.out.println("SelectionSortRuntime "+numbers.length + "Elemente: " + (stopTime-startTime) + "ns");

        return numbers;
    }

    public static void printArray(int[] numbers){
        for (int number: numbers
        ) {
            System.out.print(number+", ");
        }
    }

    public static void swap(int[] numbers, int a,int b){

        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b]=temp;

    }

}
