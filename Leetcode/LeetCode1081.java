public class LeetCode1081 {
    public static void main(String[] args) {
        System.out.println("res1: " + smallestSubsequence("bcabc"));
        System.out.println("res2: " + smallestSubsequence("cbacdcbc"));
    }

    public static String smallestSubsequence(String s) {
        // Track the last index where each character appears
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track which characters are currently in our result stack
        boolean[] seen = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is already in our stack, we can skip it
            if (seen[c - 'a']) {
                continue;
            }

            // If the current character is smaller than the top of the stack,
            // AND the top of the stack appears again later in the string,
            // pop the top of the stack to keep the result lexicographically smallest.
            while (stack.length() > 0 &&
                    stack.charAt(stack.length() - 1) > c &&
                    lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {

                // Mark the popped character as unseen so we can add it later
                seen[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            // Push the current character and mark it as seen
            stack.append(c);
            seen[c - 'a'] = true;
        }

        return stack.toString();
    }
}
