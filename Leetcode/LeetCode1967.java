public class LeetCode1967 {
    public static void main(String[] args) {
        System.out.println("res1: " + numOfStrings(new String[] { "a", "abc", "bc", "d" }, "abc"));
        System.out.println("res2: " + numOfStrings(new String[] { "a", "b", "c" }, "aaaaabbbbb"));
        System.out.println("res3: " + numOfStrings(new String[] { "a", "a", "a" }, "ab"));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int freq = 0;
        for (String str : patterns) {
            if (word.contains(str)) {
                freq++;
            }
        }

        return freq;
    }
}
