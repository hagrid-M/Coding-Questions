import java.util.*;

public class ArrayMedium {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[] indices = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remaining = target - arr[i];
            if (hm.containsKey(remaining)) {
                indices[0] = i;
                indices[1] = hm.get(remaining);
                break;
            }
            hm.put(arr[i], i);
        }
        return indices;
    }

    public void sortColors(int[] arr) {
        //variant of Dutch National flag algorithm where from mid to high, the array is unsorted
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            } else
                mid++;
        }
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        BasicHashing bm = new BasicHashing();
        HashMap<Integer, Integer> frequency = bm.frequenciesCount(nums);
        for (int num : nums) {
            if (frequency.get(num) > n / 2)
                return num;
        }
        return 0;

    }

    public int maxSubArray(int[] arr) {
        int n = arr.length;
//        int[] sumArray = new int[n];
        int currentSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        int n = arr.length;
        if (n == 2)
            return arr[0] + arr[1];
        int result = arr[0] + arr[1];
        int i = 2;
        while (i < n) {
            if (arr[i] < arr[i - 1]) {
                result = Math.max(result, arr[i] + arr[i - 1]);
                i++;
            } else if (arr[i] >= arr[i - 1]) {
                result = Math.max(result, arr[i] + arr[i - 1]);
                i++;
            }

        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int minElement = Integer.MAX_VALUE;
        for (int price : prices) {
            minElement = Math.min(minElement, price);
            maxProfit = Math.max(maxProfit, price - minElement);
        }

        return maxProfit;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posIndex = 0;
        int negIndex = 1;
        int[] result = new int[n];
        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }

        }
        return result;

    }

    public void nextPermutation(int[] nums) {
        int breakpoint = -1;
        int n = nums.length;
        int i = n - 1;
        ArrayEasy arrayEasy = new ArrayEasy();
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i ;
                break;
            }
            i--;
        }
        if (breakpoint == -1)
            arrayEasy.reverseArray(nums,0,n-1);
        for(i=n-1;i>=0;i--){
            if(nums[i]>nums[breakpoint]){
                int temp = nums[i];
                nums[i]= nums[breakpoint];
                nums[breakpoint]=temp;
                break;
            }
        }
        arrayEasy.reverseArray(nums,breakpoint+1,n-1);
    }
    public ArrayList<Integer> leaders(int[] arr) {
        // code here
        int n =  arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int maxTillNow = arr[n-1];
        for(int i=n-1; i>=0;i--){
            maxTillNow =Math.max(maxTillNow,arr[i]);
            if(maxTillNow == arr[i])
                result.add(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }
    public int longestConsecutive(int[] nums) {
        int n =nums.length;
        int maxLength = 1;
        if(n==0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int elem : nums){
            set.add(elem);
        }

        for(int elem : set){
            int tempCount=1;
            if(!set.contains(elem-1)){
                int i = 1;
                while(set.contains(elem+i)){
                    tempCount++;
                    i++;
                }
            }
            maxLength=Math.max(tempCount,maxLength);
        }
        return maxLength;

    }
}
