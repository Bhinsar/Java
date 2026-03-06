public class LeetCode1758 {
    public static void main(String[] args) {
        String s = "1111";
        int result = minOperations(s);
        System.out.println("result: " + result);
    }

    public static int minOperations(String s) {
        int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0')
                    count++;
            } else {
                if (s.charAt(i) == '1')
                    count++;
            }

        }

        return Math.min(count, length - count);
    }
}
