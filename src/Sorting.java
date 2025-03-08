import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
//        System.out.println("Swapping"+ " " + Arrays.toString(arr));

    }

    public void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE;
            int minValueIndex = -1;
            for (int j = i; j < size; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minValueIndex = j;
                }
            }
            swap(arr, minValueIndex, i);
        }
        Main.printArray(arr, arr.length);
    }

    public void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean noSwaps = true;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    noSwaps = false;
                }
            }
            if (noSwaps)
                break;
        }
        Main.printArray(arr, arr.length);
    }

    public void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i <= size - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
        Main.printArray(arr, arr.length);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }

    private void mergeSortHelper(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void mergeSort(int[] arr, int n) {
        mergeSortHelper(arr, 0, n - 1);
        Main.printArray(arr, n);
    }

    public void recursiveBubbleSort(int arr[], int n) {
        if (n == 1)
            return;
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > arr[i + 1])
                swap(arr, i, i + 1);
        }
        recursiveBubbleSort(arr, n - 1);
    }

    public void recursiveInsertionSort(int arr[], int i, int n) {
        if (i == n)
            return;
        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            swap(arr, j - 1, j);
            j--;
        }
        recursiveInsertionSort(arr, i + 1, n);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot)
                i++;
            while (j >= low + 1 && arr[j] > pivot)
                j--;
            if (i < j)
                swap(arr, i, j);

        }
        swap(arr, low, j);
//        System.out.println(Arrays.toString(arr));

        return j;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
//            System.out.println(Arrays.toString(arr));
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }
}
