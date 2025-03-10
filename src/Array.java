import java.util.ArrayList;
import java.util.HashMap;

public class Array {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int largestNumberInArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max)
                max = j;
        }
        return max;
    }

    public int secondLargestNumberInArray(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int count = 0;
        for (int i : arr) {
            if (i > largest) {
                count++;
                secondLargest = largest;
                largest = i;
            } else if (i > secondLargest && i != largest) {
                count++;
                secondLargest = i;
            }

        }
        if (count < 2)
            return -1;
        else return secondLargest;
    }

    public boolean isArraySorted(int[] arr) {
        int size = arr.length;
        int flag = 0;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (flag == 1)
                    return false;
                else
                    flag = 1;
            }
        }
        return flag != 1 || arr[0] >= arr[size - 1];
    }

    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        int size = nums.length;
        int i = 0;
        while (i < size) {
            al.add(nums[i]);
            while (i < size - 1 && nums[i] == nums[i + 1])
                i++;
        }
        int resultSize = al.size();
        for (i = 0; i < resultSize; i++) {
            nums[i] = al.get(i);
        }
        return resultSize;

    }

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void leftRotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (k % n == 0)
            return;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);

    }

    public void rightRotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (k % n == 0)
            return;
        reverseArray(arr, 0, n - k - 1);
        reverseArray(arr, n - k, n - 1);
        reverseArray(arr, 0, n - 1);

    }

    public void moveZeroesToEnd(int[] arr) {
        int n = arr.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        //no zero in the array so return the array as it is
        if (j == -1)
            return;
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }

    }

    public boolean linearSearch(int[] arr, int k) {
        for (int j : arr) {
            if (j == k)
                return true;
            else if (j > k)
                return false;
        }
        return false;
    }

    public ArrayList<Integer> unionOfSortedArrayWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> union = new ArrayList<>();
        int sizeOfFirstArray = a.length;
        int sizeOfSecondArray = b.length;
        int i = 0;
        int j = 0;
        while (i < sizeOfFirstArray && j < sizeOfSecondArray) {
            while (i < sizeOfFirstArray - 1 && a[i] == a[i + 1])
                i++;
            while (j < sizeOfSecondArray - 1 && b[j] == b[j + 1])
                j++;
            if (a[i] == b[j]) {
                union.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else {
                union.add(b[j]);
                j++;
            }

        }
        while (i < sizeOfFirstArray) {
            union.add(a[i]);
            while (i < sizeOfFirstArray - 1 && a[i] == a[i + 1])
                i++;
            i++;
        }
        while (j < sizeOfSecondArray) {
            union.add(b[j]);
            while (j < sizeOfSecondArray - 1 && b[j] == b[j + 1])
                j++;
            j++;
        }
        return union;

    }

    public int missingNumber(int[] arr) {
        int XOR1 = 0;
        int XOR2 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            XOR1 = XOR1 ^ arr[i];
            XOR2 = XOR2 ^ (i + 1);
        }
        return XOR1 ^ XOR2;
    }

    public int longestSubArrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        HashMap<Long, Integer> sumIndex = new HashMap<Long, Integer>();
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k)
                maxLength = Math.max(maxLength, i + 1);
            long remainingSum = sum - k;
            if (sumIndex.containsKey(remainingSum)) {
                maxLength = Math.max(maxLength, i - sumIndex.get(remainingSum));
            }
            //because we want to find the longest subArray, so we keep the first index occurence for that sum;
            if (!sumIndex.containsKey(sum))
                sumIndex.put(sum, i);
        }

        return maxLength;
    }

    public int longestSubArrayForPositiveIntegers(int[] arr, int k) {
        int n = arr.length;
        long sum = arr[0];
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            while(sum>k && i<=j){
                sum-=arr[i];
                i++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, j - 1 + 1);

            }
            j++;
            if(j<n)
                sum+=arr[j];
        }
        return maxLength;
    }
}
