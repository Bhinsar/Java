public class LeetCode3612 {
    public static void main(String[] args) {
        // System.out.println("res1: " + processStr("a#b%*"));
        // System.out.println("res2: " + processStr("z*#"));
        System.out.println("res3: " + processStr("*%"));
    }

    public static String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*' && !result.isEmpty()) {
                result.deleteCharAt(result.length() - 1);
            } else if (c == '#') {
                String duplicate = result.toString();
                result.append(duplicate);
            } else if (c == '%') {
                result.reverse();
            } else if (c >= 'a' && c <= 'z') {
                result.append(c);
            }
        }

        return result.toString();
    }

}