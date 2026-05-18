import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1345 {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }
    public static int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        List<Integer> queue = new ArrayList<>();
        queue.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            System.out.println(queue);
            List<Integer> next = new ArrayList<>();
            for (int index : queue) {
                if (index == arr.length - 1) {
                    return step;
                }
                if (index + 1 < arr.length && !visited[index + 1]) {
                    visited[index + 1] = true;
                    next.add(index + 1);
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    next.add(index - 1);
                }
                for (int i : map.get(arr[index])) {
                    if (!visited[i]) {
                        visited[i] = true;
                        next.add(i);
                    }
                }
                map.get(arr[index]).clear();
            }
            queue = next;
            step++;
        }
        return -1;
    }
}
