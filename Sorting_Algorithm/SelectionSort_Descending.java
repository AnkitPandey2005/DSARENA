package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class SelectionSort_Descending {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            // Change to find the minimum instead of maximum
            int getmin = minimum(arr, 0, last);
            swap(arr, getmin, last);
        }
    }

    // Find the minimum element in the array
    public static int minimum(int[] arr, int start, int end) {
        int min = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] < arr[min]) { // Change comparison to find minimum
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

