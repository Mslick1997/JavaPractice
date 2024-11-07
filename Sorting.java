import java.util.Random;
import java.util.Scanner;

public class Sorting {

    private int[] arr;
    Scanner sc = new Scanner(System.in);

    public Sorting(int n) {
        arr = new int[n];
    }

    public void randVal(int m) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(2 * m + 1) - m;
            //arr[i] = sc.nextInt();
        }
    }

    public void insertSort() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void bubbleSort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void shellSort() {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public void printVal() {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(11) + 10; 
        int m = rand.nextInt(41) + 10; 

        Sorting sArr = new Sorting(n);
        sArr.randVal(m);

        System.out.println("Random " + n + " numbers " + "[-" + m + ".." + m + "] :");
        sArr.printVal();
        
        sArr.insertSort();
        
        System.out.println("Insertion Sort :");
        sArr.printVal();
    }
}
