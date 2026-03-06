class GetBit {
    // to get the bit at position 2
    public static void main(String[] args) {
        int n = 5;
        int pos = 2;
        int bitMask = 1 << pos;
        if((bitMask & n) == 0){
            System.out.println("the number is zero");
        }else{
            System.out.println("the number is one");
        }
    }
}