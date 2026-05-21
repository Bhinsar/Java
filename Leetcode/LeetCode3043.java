
import java.util.HashSet;

public class LeetCode3043 {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 4, 4, 4 };
        System.out.println("res: " + longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxCommonPrefix = 0;

        HashSet<Integer> prefixArr1 = new HashSet<>();
        HashSet<Integer> prefixArr2 = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                prefixArr1.add(num);
                num /= 10;
            }
        }
        for (int num : arr2) {
            while (num > 0) {
                prefixArr2.add(num);
                num /= 10;
            }
        }

        for (int num : prefixArr1) {
            if (prefixArr2.contains(num)) {
                int prefixLength = 0;
                while (num > 0) {
                    prefixLength++;
                    num /= 10;
                }
                maxCommonPrefix = Math.max(maxCommonPrefix, prefixLength);
            }
        }

        return maxCommonPrefix;
    }
}