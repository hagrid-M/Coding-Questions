import java.util.List;

public class BinarySearch {
    static int findFloor(int[] arr, int x) {
        //element less than equal to
        int n = arr.length;
        int ans = -1;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;

            } else
                high = mid - 1;

        }
        return ans;
    }

    static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int ans = -1;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;

            } else
                low = mid + 1;

        }
        return ans;
    }

    public int BinarySearchHelper(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return BinarySearchHelper(arr, mid + 1, high, target);
        else
            return BinarySearchHelper(arr, low, mid - 1, target);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        return BinarySearchHelper(nums, 0, n - 1, target);
    }

    public int[] getFloorAndCeilForSortedArray(int x, int[] arr) {
        // for sorted array;
        int[] result = new int[]{-1, -1};
        int n = arr.length;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                result[0] = arr[mid];
                result[1] = arr[mid];
                break;
            } else if (arr[mid] < x) {
                result[0] = arr[mid];
                low = mid + 1;

            } else {
                result[1] = arr[mid];
                high = mid - 1;
            }


        }
        return result;
    }

    public int[] getFloorAndCeilForUnsortedArray(int x, int[] arr) {
        int[] result = new int[]{-1, -1};
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        boolean flagFloor = false;
        boolean flagCeil = false;
        for (int j : arr) {
            if (j == x) {
                flagFloor = true;
                flagCeil = true;
                floor = j;
                ceil = j;
                break;
            } else if (j < x && floor < j) {
                flagFloor = true;
                floor = j;
            } else if (j > x && ceil > j) {
                flagCeil = true;
                ceil = j;
            }
        }
        if (flagFloor)
            result[0] = floor;
        if (flagCeil)
            result[1] = ceil;
        return result;
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0])
            return 0;
        if (target > nums[n - 1])
            return n;

        int high = n - 1;
        int low = 0;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                index = mid + 1;
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    //Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findPosition(nums, target, false);
        if (firstPosition == -1)
            return new int[]{-1, -1};
        int lastPosition = findPosition(nums, target, true);
        return new int[]{firstPosition, lastPosition};
    }

    private int findPosition(int[] nums, int target, boolean firstPositionAchieved) {
        int n = nums.length;
        int high = n - 1;
        int low = 0;
        int position = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                position = mid;
                if (!firstPositionAchieved)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return position;
    }

    int countFreq(int[] arr, int target) {
        // code here
        int firstPosition = findPosition(arr, target, false);
        if (firstPosition == -1)
            return 0;
        int lastPosition = findPosition(arr, target, true);
        return (lastPosition - firstPosition) + 1;
    }

    public int searchinRotatedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    public int findKRotation(List<Integer> arr) {
        // Code here
        int index = 0;
        int high = arr.size() - 1;
        int low = 0;
        int min_value = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < min_value) {
                    index = low;
                }
                break;
            }
            if (arr.get(low) <= arr.get(mid)) {
                if (min_value > arr.get(low)) {
                    min_value = arr.get(low);
                    index = low;
                }
                low = mid + 1;
            } else {
                if (min_value > arr.get(mid)) {
                    min_value = arr.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }

        }
        return index;
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int high = n - 2;
        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((nums[mid] != nums[mid + 1]) && (nums[mid] != nums[mid - 1]))
                return nums[mid];
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int high = n - 2;
        int low = 1;
        if (n == 1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[n-1]>nums[n-2])
            return n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((nums[mid] > nums[mid - 1]) && nums[mid] > nums[mid + 1])
                return mid;
            if ((nums[mid - 1] < nums[mid]) && (nums[mid] < nums[mid + 1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;

    }
    int floorSqrt(int n) {
        // Your code here
        int low =0 ;
        int high =n;
        while(low<=high){
            long mid = (low+high)/2;
            long value = mid*mid;
            if(value <= (long) n)
                low = (int)(mid+1);
            else
                high =(int)( mid-1);
        }
        return high;
    }
    int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k)
                low = mid+1;
            else
                high = mid-1;
        }
        return low+k;

    }
}
