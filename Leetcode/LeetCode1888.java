public class LeetCode1888 {
    public static void main(String[] args) {
        System.out.println("result: " + minFlips("01001001101"));
    }

    public static int minFlips(String s) {
        int n = s.length();
        int flipCount = Integer.MAX_VALUE;
        int flip1 = 0, flip2 = 0;
        int i = 0, j = 0;

        while (j < 2 * n) {
            char currentChar = s.charAt(j % n);

            char expectedCharS1 = (j % 2 == 0) ? '1' : '0';
            char expectedCharS2 = (j % 2 == 0) ? '0' : '1';

            if (currentChar != expectedCharS1)
                flip1++;
            if (currentChar != expectedCharS2)
                flip2++;

            if (j - i + 1 > n) {
                char charToRemove = s.charAt(i % n);
                char oldExpectedS1 = (i % 2 == 0) ? '1' : '0';
                char oldExpectedS2 = (i % 2 == 0) ? '0' : '1';

                if (charToRemove != oldExpectedS1)
                    flip1--;
                if (charToRemove != oldExpectedS2)
                    flip2--;

                i++;
            }

            if (j - i + 1 == n) {
                flipCount = Math.min(flipCount, Math.min(flip1, flip2));
            }
            j++;
        }
        return flipCount;
    }
}
