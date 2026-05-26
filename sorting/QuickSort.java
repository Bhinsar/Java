public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 9,10, 5, 2, 8 };
        int n = arr.length - 1;
        sort(arr, 0, n);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            sort(arr, low, pidx - 1);
            sort(arr, pidx + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        System.out.println("low : " + low);
        System.out.println("high: " + high);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("i : " + i);
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
}
