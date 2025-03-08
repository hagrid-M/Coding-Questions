import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Sorting srt = new Sorting();
//        srt.selectionSort(arr);
//        srt.bubbleSort(arr);
//        srt.insertionSort(arr);
//        srt.mergeSort(arr,n);
//        srt.recursiveBubbleSort(arr,n);
//        srt.recursiveInsertionSort(arr,0,n);
//        srt.quickSort(arr, 0, n - 1);
        printArray(arr, n);

    }
}