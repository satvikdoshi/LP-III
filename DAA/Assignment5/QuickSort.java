package Assignment5;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1};
        quickSort(arr, 0, arr.length - 1); // Sort the entire array
        System.out.println(Arrays.toString(arr)); // Print the sorted array
    }

    // QuickSort function using the middle element as pivot
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return; // Base case: single-element or empty partition
        }

        int s = low;
        int e = high;
        int pivot = arr[(low + high) / 2]; // Choose the middle element as pivot

        while (s <= e) {
            // Move start forward while elements are less than the pivot
            while (arr[s] < pivot) {
                s++;
            }
            // Move end backward while elements are greater than the pivot
            while (arr[e] > pivot) {
                e--;
            }

            // Swap elements at start and end if needed, then move pointers
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // Recursively sort the left and right partitions
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
