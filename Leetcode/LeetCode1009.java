public class LeetCode1009 {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }

    public static int bitwiseComplement(int n) {

        String bits = Integer.toBinaryString(n);
        int result = 0;
        for (char c : bits.toCharArray()) {
            int flippedBit = (c == '0') ? 1 : 0;
            result = (result << 1) | flippedBit;
        }

        return result;

    }
}