public class LeetCode796 {
    public static void main(String[] args) {
        String s = "abcde", goal = "abced";
        System.out.println("result: " + rotateString(s, goal));

    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        goal += goal;

        return goal.contains(s);
    }
}
