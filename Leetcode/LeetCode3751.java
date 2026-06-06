public class LeetCode3751 {
    public static void main(String[] args) {
        System.out.println("res1: " + totalWaviness(120, 130));
        System.out.println("res2: " + totalWaviness(198, 202));
        System.out.println("res3: " + totalWaviness(4848, 4848));
    }

    public static int totalWaviness(int num1, int num2) {
        int count = 0;

        for (int i = num1; i <= num2; i++) {
            String str = String.valueOf(i);
            int j = 0;
            int k = j + 1;
            int l = k + 1;
            while (l < str.length()) {
                if (str.charAt(j) > str.charAt(k) && str.charAt(k) < str.charAt(l)) {
                    count++;
                    j++;
                    k++;
                    l++;
                } else if (str.charAt(j) < str.charAt(k) && str.charAt(k) > str.charAt(l)) {
                    count++;
                    j++;
                    k++;
                    l++;
                } else {
                    j++;
                    k++;
                    l++;
                }
            }

        }

        return count;
    }
}
