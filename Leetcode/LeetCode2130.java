
import java.util.ArrayList;

public class LeetCode2130 {
    public static void main(String[] args) {
        ListNode list = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        System.out.println("res: " + pairSum(list));
    }

    public static int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int maxSum = 0, i = 0, j = arr.size() - 1;
        while (i < j) {
            int sum = arr.get(i++) + arr.get(j--);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
