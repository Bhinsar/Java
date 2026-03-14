
import java.util.ArrayList;
import java.util.List;

public class LeetCode1415 {
    public static void main(String[] args) {
        System.out.println("result: " + getHappyString(1, 4));
    }

    public static String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        helper("", n, happyStrings);
        return (k <= happyStrings.size()) ? happyStrings.get(k - 1) : "";
    }

    public static void  helper(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        char[] options = {'a', 'b', 'c'};
        for (char c : options) {
            if (current.length() == 0 || c != current.charAt(current.length() - 1)) {
                helper(current+c, n, result);
            }
        }
    }
}
