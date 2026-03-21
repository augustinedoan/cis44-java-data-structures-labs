package com.mycompany.sortingalgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    // copies original times and prints each
    public static void runAndTimeAllSorts(String label, int[] original) {
        long start, end;

        int[] a = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        Sortingalgorithms.selectionSort(a);
        end = System.nanoTime();
        System.out.printf("  %s | Selection: %,d ns%n", label, end - start);

        int[] b = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        Sortingalgorithms.insertionSort(b);
        end = System.nanoTime();
        System.out.printf("  %s | Insertion: %,d ns%n", label, end - start);

        int[] c = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        Sortingalgorithms.mergeSort(c);
        end = System.nanoTime();
        System.out.printf("  %s | Merge:     %,d ns%n", label, end - start);
    }

    // average case — random order
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }

    // best case for insertion sort, sorted ascending
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    // worst case for most sorts, sorted descending order
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}
