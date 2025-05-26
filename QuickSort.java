import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int i = s + 1;
        int j = e;
        while (s < e) {
            while (i <= e && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            } else {
                swap(arr, s, j);
                return j;
            }
        }
        return j;
    }

    public static void quickSort(int[] arr, int s, int e) {
        if (s >= e) 
            return;

        int p = partition(arr, s, e);

        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

