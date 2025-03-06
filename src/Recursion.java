import java.util.ArrayList;

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

}
