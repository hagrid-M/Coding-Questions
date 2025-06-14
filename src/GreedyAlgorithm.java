import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyAlgorithm {
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int length = arr.length;
        int platform_needed = 1;
        int result = 1;
        int i = 1, j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while (i < length && j < length) {
            if (arr[i] <= dep[j]) {
                platform_needed++;
                i++;
            } else {
                platform_needed--;
                j++;
            }
            result = Math.max(result, platform_needed);
        }
        return result;
    }

    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int l = 0, r = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (l < n && r < m) {
            if (s[r] >= g[l]) {
                l++;
            }
            r++;
        }
        return l;
    }

    public boolean lemonadeChange(int[] bills) {
        int count_5 = 0;
        int count_10 = 0;
        for (int bill : bills) {
            if (bill == 5)
                count_5++;
            else if (bill == 10) {
                count_10 += 1;
                count_5 -= 1;
            } else {
                if (count_10 > 0) {
                    count_10 -= 1;
                    count_5 -= 1;
                } else
                    count_5 -= 3;
            }
            if (count_5 < 0)
                return false;

        }
        return true;
    }

    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min += 1;
                max += 1;
            } else if (c == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;

            }
            if (min < 0)
                min = 0;
            if (max < 0)
                return false;
        }
        return min == 0;
    }

    public boolean canJump(int[] nums) {
        int max_index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            max_index = Math.max(max_index, i + nums[i]);
            if (max_index < i)
                return false;

        }
        return true;
    }

    private int jumpHelper(int index, int[] nums) {
        if (index >= nums.length - 1)
            return 0;
        if (nums[index] == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int jump = 1; jump <= nums[index]; jump++) {
            int next = jumpHelper(index + jump, nums);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, next + 1); // 1 jump plus jumps from next position
            }
        }
        return min;
    }

    public int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;
        int length = nums.length;
        while (r < length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps += 1;
        }
        return jumps;
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int max_profit = 0;
        int count = 0;
        int length = deadline.length;
        Job[] jobs = new Job[length];
        for (int i = 0; i < length; i++) {
            jobs[i] = new Job(deadline[i], profit[i], i + 1);
        }
        Arrays.sort(jobs, (a, b) -> (b.profit - a.profit));
        int max_deadline = 0;
        for (Job j : jobs) {
            max_deadline = Math.max(max_deadline, j.deadline);
        }
        int[] res = new int[max_deadline + 1];
        for (int i = 0; i <= max_deadline; i++)
            res[i] = -1;
        for (int i = 0; i < length; i++) {
            int j = jobs[i].deadline;
            while (j >= 0) {
                if (res[j] < 0) {
                    res[j] = jobs[i].position;
                    max_profit += jobs[i].profit;
                    count++;
                    break;
                }
                j--;
            }
        }

        int finalCount = count;
        int finalMax_profit = max_profit;
        return new ArrayList<>() {{
            add(finalCount);
            add(finalMax_profit);
        }};
    }

    public int candy(int[] ratings) {
        int min_candy = 0;
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else left[i] = 1;
        }
        int curr_right = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr_right += 1;
            } else {
                curr_right = 1;
            }
            min_candy += Math.max(left[i], curr_right);
        }
        min_candy += left[n - 1];
        return min_candy;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min( newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][]);
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        int i=1;
        while(i<n){
            if(right>=intervals[i][0]){
                right = Math.max(right,intervals[i][1]);
            }
            else{
                result.add(new int[]{left,right});
                left=intervals[i][0];
                right = intervals[i][1];
            }
            i++;
        }
        result.add(new int[]{left,right});
        return result.toArray(new int[0][]);

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int result =0;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int n = intervals.length;
        int right = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=right){
                result+=1;
                right = intervals[i][1];
            }
        }
        return n-result;
    }

    public class Job {
        int deadline;
        int profit;
        int position;

        Job(int x, int y, int z) {
            deadline = x;
            profit = y;
            position = z;
        }
    }
}
