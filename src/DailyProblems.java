public class DailyProblems {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        int length = s.length();
        char c ='9';
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (flag) {
                if(s.charAt(i)==c)
                    max.append('9');
                else
                    max.append(s.charAt(i));
            }
            else {
                if(s.charAt(i)!='9'){
                    flag = true;
                    c=s.charAt(i);
                }
                max.append('9');

            }

        }
        flag = false;
        for (int i = 0; i < length; i++) {
            if (flag) {
                if(s.charAt(i)==c)
                    min.append('0');
                else
                    min.append(s.charAt(i));
            } else {
                if(s.charAt(i)!='0'){
                    flag = true;
                    c=s.charAt(i);
                }
                min.append('0');

            }

        }
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());

    }
}
