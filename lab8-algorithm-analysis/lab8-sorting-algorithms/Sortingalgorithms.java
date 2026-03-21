package com.mycompany.sortingalgorithms;

import java.util.Arrays;
import java.util.Random;

public class Sortingalgorithms {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            SortingTester.runAndTimeAllSorts("Average Case (Random)  ", SortingTester.generateRandomArray(n));
            SortingTester.runAndTimeAllSorts("Best Case   (Sorted)   ", SortingTester.generateSortedArray(n));
            SortingTester.runAndTimeAllSorts("Worst Case  (Reversed) ", SortingTester.generateReverseSortedArray(n));
        }
    }

    // finds minimum & swaps it into place
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //shifts elements right until key fits
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // starts recursion
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSortHelper(arr, new int[arr.length], 0, arr.length - 1);
    }

    // splits array sorts then merges 
    private static void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortHelper(arr, temp, left, mid);
        mergeSortHelper(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    // merges two halves into arr in sorted order
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) temp[i] = arr[i];

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right)
            arr[k++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];

        while (i <= mid) arr[k++] = temp[i++];
    }
}
