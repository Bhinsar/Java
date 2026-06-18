public class LeetCode3614 {
    public static void main(String args[]) {
        System.out.println("res1: " + processStr("a#b%*", 1));
        System.out.println("res2: " + processStr("cd%#*#", 3));
        System.out.println("res3: " + processStr("z*#", 0));
    }

    public static char processStr(String s, long k) {
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
        return (k >= 0 && k < result.length()) ? result.charAt((int) k) : '.';
    }
}