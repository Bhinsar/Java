class MixedNumber {
    public static void main(String args[]) {
        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                System.out.print("* ".repeat(i));
            } else {
                int mid = (i + 1) / 2;
                for (int j = 1; j <= mid; j++) {
                    System.out.print(j + " ");
                }
                for (int j = mid - 1; j >= 1; j--) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}