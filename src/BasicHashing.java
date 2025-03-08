import java.util.HashMap;

public class BasicHashing {
    public HashMap<Integer, Integer> frequenciesCount(int[] arr){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int length = arr.length;
        for (int number : arr) {
            if (freq.containsKey(number)) {
                freq.put(number, freq.get(number) + 1);
            } else
                freq.put(number, 1);
        }
        return freq;
    }
}
