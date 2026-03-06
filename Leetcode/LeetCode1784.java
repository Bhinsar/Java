public class LeetCode1784 {
    public static void main(String[] args) {
         String s = "111110";
        //String s = "1101111";
        System.out.println("result: " + checkOnesSegment(s));
    }

    public static boolean checkOnesSegment(String s) {
        boolean result = true;

        if(s.startsWith("0"))return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                result = false;
            }
        }

        return result;
    }
}
