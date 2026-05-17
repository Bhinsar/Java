class LeetCode1306 {
    public static void main(String args[]) {
        int nums[] = { 3, 0, 2, 1, 2 };
        System.out.println("res: " + canReach(nums, 2));

    }

    public static boolean canReach(int[] arr, int start) {
        boolean isVisited[] = new boolean[arr.length];
        return helper(arr, start, isVisited);
    }

    private static boolean helper(int[] arr, int start, boolean isVisited[]) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        if (isVisited[start]) {
            return false;
        }
        isVisited[start] = true;

        return helper(arr, start + arr[start], isVisited) ||
                helper(arr, start - arr[start], isVisited);
    }
}
