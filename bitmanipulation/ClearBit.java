public class ClearBit {
    // to set bit at position 2 as 0
    public static void main(String[] args) {
        int n = 5;
        int pos =2;
        int bitMask = 1<< pos;
        int NotbitMask = ~bitMask;
        int NewNumber = NotbitMask & n;
        System.out.println(NewNumber);
    }
}
