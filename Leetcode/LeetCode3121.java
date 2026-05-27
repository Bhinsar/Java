import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3121 {
    public static void main(String[] args) {
        String s = "AbBCab";
        System.out.println("res: " + numberOfSpecialChars(s));
    }

    public static int numberOfSpecialChars(String word) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), new ArrayList<>());
            }
            map.get(word.charAt(i)).add(i);

        }
        for (Map.Entry<Character, List<Integer>> en : map.entrySet()) {

            char lowerCase = (char) (en.getKey() + 32);
            
            if (map.containsKey(lowerCase)) {
                System.out.println(en.getKey());
                System.out.println(lowerCase);
                List<Integer> vals = en.getValue();
                List<Integer> lowerVals = map.get(lowerCase);
                System.out.println("vals: "+vals);
                System.out.println("LowerVals: "+lowerVals);

                int lastLower = lowerVals.get(lowerVals.size() - 1);
                int firstUpper = vals.get(0);

                
                if (firstUpper > lastLower) {
                    System.out.println("lastLower: "+ lastLower);
                    System.out.println("firstUpper: "+ firstUpper);
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int lastIndexOf(List vals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }
}
