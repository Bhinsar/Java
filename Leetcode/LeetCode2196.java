
import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void display() {
        displayHelper(this, "", true);
    }

    private void displayHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        // Print the current node with its indentation prefix
        System.out.println(prefix + (isLeft ? "├── L: " : "└── R: ") + node.val);

        // Enter the next level of recursion, updating the prefix for alignment
        String newPrefix = prefix + (isLeft ? "│   " : "    ");

        // Recurse for left and right children
        if (node.left != null || node.right != null) {
            displayHelper(node.left, newPrefix, true);
            displayHelper(node.right, newPrefix, false);
        }
    }
}

public class LeetCode2196 {
    public static void main(String[] args) {
        int des[][] = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 } };
        int des1[][] = { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } };
        TreeNode t = createBinaryTree(des);
        t.display();
        TreeNode t1 = createBinaryTree(des1);
        t1.display();
    }

    static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = nodeMap.get(childVal);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            TreeNode r= nodeMap.get(parentVal);
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }

        return null;

    }

}
