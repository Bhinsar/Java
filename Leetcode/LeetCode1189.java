
import java.util.HashMap;
import java.util.Map;

public class LeetCode1189 {
    public static void main(String args[]) {
        // System.out.println("res1: " + maxNumberOfBalloons("nlaebolko"));
        System.out.println("res2: " + maxNumberOfBalloons("loonbalxballpoon"));
        // System.out.println("res3: " + maxNumberOfBalloons("leetcode"));
    }

    public static int maxNumberOfBalloons(String text) {
        String traget = "balloon";
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : traget.toCharArray()) {
            freq.put(c, 0);
        }
        int freqL = 0;
        int freqO = 0;
        for (char c : text.toCharArray()) {

            if (freq.containsKey(c)) {
                switch (c) {
                    case 'l' -> {
                        freqL++;
                        if (freqL != 0 && freqL % 2 == 0) {
                            freq.put(c, freq.get(c) + 1);
                        }
                        
                    }
                    case 'o' -> {
                        freqO++;
                        if (freqO != 0 && freqO % 2 == 0) {
                            freq.put(c, freq.get(c) + 1);
                        }
                        
                    }
                    default -> freq.put(c, freq.get(c) + 1);
                }
            }
        }
        int count = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> en : freq.entrySet()) {
            count = Math.min(en.getValue(), count);
        }

        return count;
    }
}