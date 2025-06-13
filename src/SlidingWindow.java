import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[length + 1 - k];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            if (i >= k - 1) result[index++] = nums[dq.peekFirst()];

        }
        return result;

    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] hm = new int[256];
        for (int i = 0; i < 256; i++)
            hm[i] = -1;
        if (length == 1) return 1;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < length) {
            char c = s.charAt(right);
            if (hm[c] != -1) {
                if (hm[c] >= left) left = hm[c] + 1;
            }
            result = Math.max(result, right - left + 1);
            hm[c] = right;
            right++;
        }
        return result;

    }

    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int l = 0, r = 0, result = 0, zero_count = 0;
        while (r < length) {
            if (nums[r] == 0) {
                zero_count += 1;
            }
            while (zero_count > k) {
                if (nums[l] == 0) zero_count -= 1;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;

        }
        return result;

    }

    public int characterReplacement(String s, int k) {
        int result = 0, l = 0, r = 0, max_frequency = 0;
        int length = s.length();
        int[] frequency = new int[26];
        while (r < length) {
            frequency[s.charAt(r) - 'A'] += 1;
            max_frequency = Math.max(frequency[s.charAt(r) - 'A'], max_frequency);
            if ((r - l + 1) - max_frequency <= k) {
                result = Math.max(result, r - l + 1);
            } else {
                frequency[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }

            r++;
        }
        return result;

    }

    private int numSubarrayWithgoal(int[] nums, int goal) {
        int count = 0;
        if (goal < 0) return 0;
        int length = nums.length;
        int l = 0, r = 0, sum = 0;
        while (r < length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l += 1;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayWithgoal(nums, goal) - numSubarrayWithgoal(nums, goal - 1);
    }

    public int numberOfSubarraysCount(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        int l = 0, r = 0, number_of_odds = 0;
        if (k < 0) return 0;
        while (r < length) {
            number_of_odds += (nums[r] & 1);
            while (number_of_odds > k) {
                number_of_odds -= (nums[l] & 1);
                l += 1;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return (numberOfSubarraysCount(nums, k) - numberOfSubarraysCount(nums, k - 1));
    }

    private int min(int[] last_seen) {
        if (last_seen[0] < last_seen[1] && last_seen[0] < last_seen[2]) return last_seen[0];
        else return Math.min(last_seen[1], last_seen[2]);

    }

    public int numberOfSubstrings(String s) {
        int count = 0;
        int length = s.length();
        int[] last_seen = new int[]{-1, -1, -1};
        for (int i = 0; i < length; i++) {
            last_seen[s.charAt(i) - 'a'] = i;
            if (last_seen[0] != -1 && last_seen[1] != -1 && last_seen[2] != -1) count += (1 + min(last_seen));
        }
        return count;
    }

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int maxPoint = 0, leftSum = 0, rightSum = 0, l = 0, r = length - 1;
        while (l < k) {
            leftSum += cardPoints[l];
            l++;
        }
        maxPoint = leftSum;
        l -= 1;
        while (l >= 0) {
            leftSum -= cardPoints[l];
            rightSum = rightSum + cardPoints[r];
            maxPoint = Math.max(leftSum + rightSum, maxPoint);
            l--;
            r--;
        }
        return maxPoint;
    }

    private int subarraysWithLessOrEqualKDistinct(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        int l = 0, r = 0;
        if (k < 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (r < length) {
            if (!hm.containsKey(nums[r])) hm.put(nums[r], 1);
            else {
                hm.put(nums[r], hm.get(nums[r]) + 1);
            }
            while (hm.size() > k) {
                if (hm.get(nums[l]) == 1) hm.remove(nums[l]);
                else hm.put(nums[l], hm.get(nums[l]) - 1);
                l += 1;
            }
            count = count + r - l + 1;
            r++;
        }
        return count;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return (subarraysWithLessOrEqualKDistinct(nums, k) - subarraysWithLessOrEqualKDistinct(nums, k - 1));
    }

    public String minWindow(String s, String t) {
        int startingIndex = -1;
        int min_length = Integer.MAX_VALUE;
        int count = 0;
        int[] hm = new int[256];
        int l = 0, r = 0, l1 = s.length(), l2 = t.length();
        if(l2>l1)
            return "";
        for (int i = 0; i < l2; i++) {
            hm[t.charAt(i)]++;
        }
        while (r < l1) {
            char c = s.charAt(r);
            if (hm[c] > 0) count++;
            hm[c]--;
            while (count == l2) {
                if (r - l + 1 < min_length) {
                    min_length = r - l + 1;
                    startingIndex = l;
                }
                hm[s.charAt(l)]++;
                if (hm[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;

        }
        return startingIndex == -1 ? "" : s.substring(startingIndex, startingIndex+min_length);
    }
}
