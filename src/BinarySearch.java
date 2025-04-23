public class BinarySearch {
    private int calculateHours(int[] piles, int k) {
        int count = 0;
        for (int pile : piles) {
            count += Math.ceil(pile/ (double) k);
        }
        return count;
    }

    private int findMaxElement(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int elem : piles) {
            max = Math.max(max, elem);
        }
        return max;
    }
    private int findMinElement(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int ar: arr){
            min=Math.min(min,ar);
        }
        return min;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMaxElement(piles);
        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = calculateHours(piles, mid);
            if(hours<=h)
                high = mid-1;
            else
                low = mid+1;

        }

        return low;

    }
    private boolean isPossible(int[] bloomDay, int m, int k, int day){
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int j : bloomDay) {
            if (j <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        int size =  bloomDay.length;
        int low = findMinElement(bloomDay);
        int high = findMaxElement(bloomDay);
        long val = (long) m * k ;
        if(val > size)
            return -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(bloomDay,m,k,mid))
                high= mid -1;
            else
                low= mid+1;

        }
        return low;
    }
    private int findDivisorSum(int[] nums, int divisor){
        int count = 0;
        for(int elem: nums){
            count += Math.ceil(elem/(double)divisor);
        }
        return count;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int high = findMaxElement(nums);
        int low = 1;
        while(low<=high){
            int mid =(low+high)/2;
            int divisor = findDivisorSum(nums, mid);
            if(divisor<=threshold)
                high = mid-1;
            else low = mid+1;
        }
        return low;

    }
    private int findDays(int[] weights, int mid){
        int weight  = 0;
        int days = 1;
        for(int elem :  weights){
            if((weight+elem)<=mid)
                weight+=elem;
            else{
                days++;
                weight = elem;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        for(int weight:weights){
            high+=weight;
        }
        int low = findMaxElement(weights);
        while(low<=high){
            int mid = (low+high)/2;
            int temp_days = findDays(weights,mid);
            if(temp_days<=days)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;

    }


}
