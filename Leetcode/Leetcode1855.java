public class Leetcode1855 {
    public static void main(String[] args) {
        int num1[] = { 55, 30, 5, 4, 2 };
        int num2[] = { 100, 20, 10, 10, 5 };
        System.out.println("result: " + maxDistance(num1, num2));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                int dist = j - i;
                if (j == m - 1 && dist > maxDist) {
                    return dist;
                } else {
                    maxDist = Math.max(dist, maxDist);
                }
                j++;
            } else {
                i++;
                j++;
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < m; j++) {
        // if(nums1[i] <= nums2[j]){
        // int dist = j-i;
        // if(j==m-1 && dist > maxDist){
        // return dist;
        // }else{
        // maxDist = Math.max(dist, maxDist);
        // }
        // }else{
        // break;
        // }
        // }
        // }

        return maxDist;
    }
}
