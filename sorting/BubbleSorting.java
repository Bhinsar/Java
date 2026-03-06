class BubbleSorting {
    public static void main(String args[]) {
        int num[] = { 7, 8, 3, 9, 10 };
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < (num.length - 1) - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}