import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    ArrayList<Long> result = new ArrayList<Long>();
    StringBuilder sb = new StringBuilder();
    public void print(int cnt) {
        // Base Condition.
        if (cnt == 3) return;
        System.out.println(cnt);

        // Count incremented.
        cnt = cnt + 1;
        print(cnt);

    }

    public ArrayList<Long> getFact(long i, long curr, long n) {
        if (curr > n)
            return result;
        result.add(curr);
        return getFact(i + 1, curr * (i + 1), n);
    }

    public ArrayList<Long> factorialNumbers(long n) {
        // code here
        //as we are using result which is a global variable, it needs to be cleared after every computation

        result.clear();
        return getFact(1, 1, n);
    }

    public void reverseArrayHelper(int[] arr, int start, int end){
        if(start<end){
            int temp= arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            reverseArrayHelper(arr,start+1,end-1);
        }
    }
    public void reverseArray(int[] arr){
        reverseArrayHelper(arr,0,arr.length-1);
    }
    public boolean isPalindromeHelper(String str, int start, int end){
        if(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
           return isPalindromeHelper(str,start+1,end-1);
        }
        return true;
    }
    public boolean isPalindrome(String str){
        return isPalindromeHelper(str, 0, str.length()-1);
    }
    public ArrayList<Long> fibonacciHelper(long n, long prev, long next){
        if(n>=0){
            result.add(prev);
            long temp = prev+next;
            prev=next;
            next=temp;
            return fibonacciHelper(n-1,prev,next);

        }
        return result;

    }
    public ArrayList<Long> fibonacci(int n){
        result.clear();
       return fibonacciHelper(n,0,1);
    }
    private final long mod = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n /2;
        long first = pow(5,even)%mod;
        long second = pow(4,odd) % mod;
        return (int)((first*second)% mod);
    }
    private long  pow(long x, long n){
        if (n == 0) return 1;
        long temp = pow(x,n/2);

        if (n % 2 == 0){
            return (temp*temp)% mod;

        }
        return (x*temp*temp)% mod;

    }
    private void dfs(int openParenthesis, int closeParenthesis, List<String> result, String s, int n){
        if(openParenthesis == closeParenthesis && (openParenthesis+closeParenthesis) == 2*n){
            result.add(s);
            return;
        }
        if(openParenthesis<n){
            dfs(openParenthesis+1,closeParenthesis,result,s+"(",n);
        }
        if(closeParenthesis<openParenthesis){
            dfs(openParenthesis,closeParenthesis+1,result,s+")",n);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int openParenthesis =0 ;
        int closeParenthesis = 0;

        dfs(openParenthesis,closeParenthesis,result,"", n);
        return result;

    }

    private void createSubset(int[] nums, List<Integer> subset, List<List<Integer>> result, int index){
        if(index==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        createSubset(nums,subset,result,index+1);
        subset.removeLast();
        createSubset(nums,subset,result,index+1);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubset(nums,subset,result,0);
        return result;

    }
    private int generateSubsequence(int[]nums, int k, int sum, int index, int n){
       if(index==n){
           if(sum==k)
               return 1;
           else return 0;
       }
        sum+=nums[index];
        int l = generateSubsequence(nums,k,sum,index+1,n);
        sum-=nums[index];
        int r = generateSubsequence(nums,k,sum,index+1,n);
        return l+r;

    }
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
       return generateSubsequence(nums,k,0,0,nums.length);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, target, 0);
        return list;

    }
    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) {
        }
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums, remain - nums[i], i+1); // not i + 1 because we can reuse same elements
                tempList.removeLast();
            }
        }
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) {
        }
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.removeLast();
            }
        }
    }


}
