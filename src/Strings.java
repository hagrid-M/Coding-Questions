import java.util.Arrays;
import java.util.Stack;

public class Strings {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        if (len <= 2) return "";
        char[] c = s.toCharArray();
        StringBuilder newString = new StringBuilder();
        int open = 1;
        for (int i = 1; i < len; i++) {
            if (c[i] == '(') {
                open++;
                if (open > 1) newString.append('(');
            }
            else {
                if (open > 1) newString.append(')');
                open--;
            }
        }
        return newString.toString();
    }
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[]str =s.split("\\s+");
        int size = str.length;
        for(int i = size-1; i>=0;i--){
            result.append(str[i]).append(" ");
        }

        return result.toString().trim();
    }
    public String largestOddNumber(String num) {
        int n = num.length();
        while(n>0){
            n--;
            if(Integer.parseInt(String.valueOf(num.charAt(n))) %2 !=0){
                return num.substring(0,n+1);
            }
        }
        return "";
    }
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 1)
            return strs[0];
        if (length == 0) return "";
        Arrays.sort(strs);
        int length_first = strs[0].length();
        int length_last=strs[length-1].length();
       for(int i=0;i<length_first;i++){
           if(i>length_last || strs[0].charAt(i)!=strs[length-1].charAt(i))
               return strs[0].substring(0,i);
       }
       return "";

    }

}
