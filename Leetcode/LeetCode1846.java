
import java.util.Arrays;

public class LeetCode1846 {
    public static void main(String[] args) {
        System.out.println("res1 : " + maximumElementAfterDecrementingAndRearranging(new int[] { 2, 2, 1, 2, 1 }));
        System.out.println("res2 : " + maximumElementAfterDecrementingAndRearranging(new int[] { 100, 1, 1000 }));
        System.out.println("res3 : " + maximumElementAfterDecrementingAndRearranging(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if(diff >1){
                arr[i] = arr[i-1]+1;
            }
        }

        return arr[arr.length-1];
    }
}
