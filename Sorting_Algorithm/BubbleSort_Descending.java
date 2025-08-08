package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class BubbleSort_Descending {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 1};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                // Change the comparison to sort in descending order
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
