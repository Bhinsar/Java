class LeetCode2839 {
    public static void main(String args[]) {
        System.out.println("result: " + canBeEqual("bnxw", "bwxn"));
    }

    public static boolean canBeEqual(String s1, String s2) {

        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if (i < 2 && s1.charAt(i) != s2.charAt(i + 2)) {
                return false;
            } else if (i >= 2 && s1.charAt(i) != s2.charAt(i - 2)) {
                return false;
            }
        }

        return true;
    }
}