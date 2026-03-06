public class LeetCode1545 {
    public static void main(String[] args) {
        // Example: n=3, k=1 -> Result: "0"
        // S1 = "0"
        // S2 = "0" + "1" + "1" = "011"
        // S3 = "011" + "1" + "001" = "0111001"
        System.out.println(findKthBit(3, 1)); 
    }

    public static char findKthBit(int n, int k) { 
        if (n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char correspondingBit = findKthBit(n - 1, length - k + 1);
            return (correspondingBit == '0') ? '1' : '0';  
        }
    }
}