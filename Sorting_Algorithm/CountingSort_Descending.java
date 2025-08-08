package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class CountingSort_Descending {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;

        // Find the largest element in the array
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Create a count array
        int[] count = new int[largest + 1];

        // Count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;

        // Fill the original array in descending order
        for (int i = count.length - 1; i >= 0; i--) { // Start from the end of count array
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
}
