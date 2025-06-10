
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printList(List<Integer> result) {
        for (int elem : result) {
            System.out.print(elem + " ");
        }

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       int m = sc.nextInt();
       char[][] nums = new char[n][m];
       for(int i =0 ;i<n;i++){
           for(int j=0;j<m;j++){
               nums[i][j]= sc.next().charAt(0);
           }

       }
       Stacks st = new Stacks();
       System.out.println(st.maximalRectangle(nums));
    }
}