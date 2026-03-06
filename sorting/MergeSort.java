class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length - 1;
        divide(arr, 0, n, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void divide(int[] arr, int si, int ei, int i) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        System.out.println("************");
        System.out.println("step "+ i);
        System.out.println("array values: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("mid: "+ mid);
        System.out.println("si: "+ si);
        System.out.println("ei: "+ ei);
        System.out.println("************");
        
        divide(arr, si, mid, i + 1);
        divide(arr, mid + 1, ei, i + 1);
        conqure(arr, si, mid, ei);

    }

    public static void conqure(int[] arr, int si, int mid, int ei) {
        int merged[] = new int[(ei - si) + 1];
        System.out.println("************");
        System.out.println("array values: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("mid: "+ mid);
        System.out.println("si: "+ si);
        System.out.println("ei: "+ ei);
        System.out.println("************");
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2])
                merged[x++] = arr[idx1++];
            else
                merged[x++] = arr[idx2++];
        }
        while (idx1 <= mid)
            merged[x++] = arr[idx1++];
        while (idx2 <= ei)
            merged[x++] = arr[idx2++];

        for (int i = 0, j = si; i < merged.length; i++, j++)
            arr[j] = merged[i];

    }
}