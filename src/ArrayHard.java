import java.util.*;

public class ArrayHard {
    //Pascal triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0 || j + 1 > i)
                    row.add(1);
                else {
                    row.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
                }

            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;

    }

    public List<Integer> majorityElement(int[] v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int j : v) {
            if (cnt1 == 0 && el2 != j) {
                cnt1 = 1;
                el1 = j;
            } else if (cnt2 == 0 && el1 != j) {
                cnt2 = 1;
                el2 = j;
            } else if (j == el1) cnt1++;
            else if (j == el2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0;
        cnt2 = 0;
        for (int j : v) {
            if (j == el1) cnt1++;
            if (j == el2) cnt2++;
        }

        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            //remove duplicates for unique triplets
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = target - nums[i];
                    sum -= nums[j];
                    sum -= nums[k];
                    sum -= nums[l];
                    if (sum < 0)
                        l--;
                    else if (sum > 0)
                        k++;
                    else {
                        List<Integer> quadruples = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(quadruples);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }

        return result;

    }

    public int maxLen(int nums[]) {
        // code here
        int result = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        prefixSum.put(sum, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (prefixSum.containsKey(sum)) {
                result = Math.max(result, i - prefixSum.get(sum));
            } else
                prefixSum.put(sum, i);
        }
        return result;
    }

    public List<int[]> mergeIntervals(int[][] intervals) {
        int rows = intervals.length;
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int i = 0;
        int max = intervals[0][1];
        while (i < rows) {
            int j = i + 1;
            max = intervals[j - 1][1];
            int[] temp = new int[2];
            while (j < rows && intervals[j][0] <= max) {
                j++;
                max = Math.max(max, intervals[j - 1][1]);

            }
            temp[0] = (intervals[i][0]);
            temp[1] = max;
            result.add(temp);
            i = j;
        }

        return result;
    }


}
