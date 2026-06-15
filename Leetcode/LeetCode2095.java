
public class LeetCode2095 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1,
                new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        ListNode res = deleteMiddle(list);

        while (res != null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // while (head != null) {
        // arr.add(head.val);
        // head = head.next;
        // }
        // int mid = (arr.size() - 1) / 2;
        // ListNode res = null;
        // for (int i = arr.size() - 1; i >= 0; i--) {
        // if (i == mid) {
        // continue;
        // } else {
        // res = new ListNode(arr.get(i), res);

        // }
        // }
        // return res;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
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