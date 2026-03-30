public class LeetCode2840 {
    public static void main(String[] args) {
        // System.out.println(checkStrings("abe", "bea"));
        System.out.println(checkStrings("abcdbaa", "cabdabt"));
    }

    public static boolean checkStrings(String s1, String s2) {

        int length = s1.length();

        int even[] = new int[26];
        int odd[] = new int[26];

        for (int i = 0; i < length; i++) {
            if (i == 0 || i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0)
                return false;
        }

        return true;
    }
}
