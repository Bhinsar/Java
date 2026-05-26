
import java.util.HashMap;
import java.util.Map;

public class LeetCode3120 {
    public static void main(String[] args) {
        String s = "aaAbcBC";
        System.out.println("res: " + numberOfSpecialChars(s));
    }

    public static int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            char upperCh = (char) (en.getKey() - 32);
            if (map.containsKey(upperCh)) {
                ans++;
            }
        }

        return ans;
    }

}
