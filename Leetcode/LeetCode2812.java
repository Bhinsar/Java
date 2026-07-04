import java.util.List;

public class LeetCode2812 {
    public static void main(String[] args) {
        List<List<Integer>> list1 = List.of(
                List.of(1, 0, 0),
                List.of(0, 0, 0),
                List.of(0, 0, 1));
        List<List<Integer>> list2 = List.of(
                List.of(0, 0, 1),
                List.of(0, 0, 0),
                List.of(0, 0, 0));
        List<List<Integer>> list3 = List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0),
                List.of(1, 0, 0, 0));
        System.out.println("res1: " + maximumSafenessFactor(list1));
        System.out.println("res2: " + maximumSafenessFactor(list2));
        System.out.println("res3: " + maximumSafenessFactor(list3));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.;
    }
}
