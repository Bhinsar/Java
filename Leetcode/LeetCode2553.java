import java.util.ArrayList;
import java.util.Stack;

public class LeetCode2553 {
    public static void main(String args[]) {
        int[] nums = { 32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99 };
        System.out.println("res:");
        nums = separateDigits(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int temp = num;

            if (temp == 0) {
                list.add(0);
                continue;
            }

            Stack<Integer> digits = new Stack<>();
            while (temp > 0) {
                digits.push(temp % 10);
                temp /= 10;
            }

            while (!digits.isEmpty()) {
                list.add(digits.pop());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
