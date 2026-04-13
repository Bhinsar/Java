public class LeetCode1848 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println("result: " + getMinDistance(nums, 5, 3));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        if (nums[start] == target)
            return 0;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                int dist = Math.abs(i - start);
                minDist = Math.min(minDist, dist);
            }   
        }

        return minDist;
    }
}
