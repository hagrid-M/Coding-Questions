public class BasicMaths {
    public int dividesExactly(int n) {
        int count = 0;
        int number = n; //12
        while (n >= 1) {
            int digit = n % 10;
            if (digit != 0) {
                //check if the number is divisible by that particular digit
                if (number % digit == 0)
                    count++;
            }
            n /= 10;

        }
        return count;
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (x < 0) {
            sb.append('-');
            x = Math.abs(x);
        }

        while (x >= 1) {

            int digit = x % 10;
            if (flag != 0 || digit != 0) {
                // add digits to the string builder
                sb.append(digit);
                flag = 1;
            }
            x /= 10;


        }
        if (sb.toString().isEmpty())
            return 0;
        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isPalindrome(int x) {
        return (x == reverse(x));
    }

    public int sumOfDivisors(int n) {
        // code here
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    //if number is a perfect square, just add the number once;
                    if (Math.sqrt(i) != j)
                        sum += (j + (i / j));
                    else sum += j;
                }

            }
        }
        return sum;
    }

    public int GCD(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return Math.max(n1, n2);
        if (n1 > n2)
            n1 = n1 % n2;
        else
            n2 = n2 % n1;
        return GCD(n1, n2);
    }

}
