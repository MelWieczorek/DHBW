package Semester2.algorithms;

public class bubblesort {

    public static void main(String[] args) {
        //Bubblesort v1
        int[] toSort = {50,70,100,60,80,40,30,20,10};

        bubbleSort(toSort);
        printArray(toSort);

        //Bubblesort v2
        int[] toSortv2 = {50,70,100,60,80,40,30,20,10};

        System.out.println("");
        System.out.println("");
        bubbleSortv2(toSortv2);
        printArray(toSortv2);

        //Bubblesort v3
        int[] toSortv3 = {50,70,100,60,80,40,30,20,10};

        System.out.println("");
        System.out.println("");
        bubbleSortv3(toSortv3);
        printArray(toSortv3);
        System.out.println("");
        System.out.println("");
        System.out.println("BubbleSortv3 auf sortiert: ");
        bubbleSortv3(toSortv3);
        printArray(toSortv3);
    }


    public static int[] bubbleSort(int[] numbers){

        long startTime = System.nanoTime();

        for (int i = numbers.length; i>0; i--){
            for (int j =0; j<numbers.length -1; j++){
                if (numbers[j]>numbers[j+1]){
                    //swap

                    swap( numbers, j,j+1);
                }
            }
        }

        long stopTime = System.nanoTime();

        System.out.println("BubbleSortRuntime "+numbers.length + "Elemente: " + (stopTime-startTime) + "ns");

        return numbers;
    }

    public static int[] bubbleSortv2(int[] numbers){

        long startTime = System.nanoTime();

        for (int i = numbers.length; i>0; i--){
            for (int j =0; j<i-1; j++){ //Optimiert: Durchläuft bei jedem Durchlauf weniger --> größten wurden auf jeden Fall bereits nach hinten gesschoben
                if (numbers[j]>numbers[j+1]){
                    swap( numbers, j,j+1);
                }
            }
        }

        long stopTime = System.nanoTime();

        System.out.println("BubbleSortRuntime V2 "+numbers.length + "Elemente: " + (stopTime-startTime) + "ns");

        return numbers;
    }

    public static int[] bubbleSortv3(int[] numbers){

        int j = numbers.length -1;
        boolean swapped = false;
        long startTime = System.nanoTime();

        do {
            swapped = false;
            for (int i =0;i<j;i++){
                if (numbers[i] > numbers[i+1]){
                    swap(numbers,i,i+1);
                    swapped=true;
                }
            }
            j--;

        }while (swapped);

        long stopTime = System.nanoTime();

        System.out.println("BubbleSortRuntime V3 "+numbers.length + "Elemente: " + (stopTime-startTime) + "ns");

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
