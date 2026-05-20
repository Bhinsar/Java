
public class LeetCode2657 {
    public static void main(String[] args) {
        int A[] = { 2, 3, 1 };
        int B[] = { 3, 1, 2 };
        int res[] = findThePrefixCommonArray(A, B);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int[] freq = new int[A.length+1];
        int common = 0;
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                common++;
            }
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }
}
