package com.mycompany.sortingalgorithmslab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {

    public static void main(String[] args) {

        Comparator<Integer> comp = Comparator.naturalOrder();
        Random rand = new Random();
        int N = 10;

        // TEST CASE 1: RANDOM
        Integer[] random = new Integer[N];
        for (int i = 0; i < N; i++) {
            random[i] = rand.nextInt(100);
        }

        runTest("RANDOM ARRAY", random, comp);

        // TEST CASE 2: SORTED
        Integer[] sorted = new Integer[N];
        for (int i = 0; i < N; i++) {
            sorted[i] = i;
        }

        runTest("SORTED ARRAY", sorted, comp);

        // TEST CASE 3: REVERSE SORTED
        Integer[] reverse = new Integer[N];
        for (int i = 0; i < N; i++) {
            reverse[i] = N - i;
        }

        runTest("REVERSE SORTED ARRAY", reverse, comp);
    }

    public static void runTest(String title, Integer[] arr, Comparator<Integer> comp) {

        Integer[] mergeArr = Arrays.copyOf(arr, arr.length);
        Integer[] quickArr = Arrays.copyOf(arr, arr.length);

        System.out.println("\n===== " + title + " =====");

        // BEFORE sorting
        System.out.println("Before: " + Arrays.toString(arr));

        // Merge Sort
        AdvancedSorters.mergeSort(mergeArr, comp);
        System.out.println("After Merge Sort: " + Arrays.toString(mergeArr));

        // Quick Sort
        AdvancedSorters.quickSort(quickArr, comp);
        System.out.println("After Quick Sort: " + Arrays.toString(quickArr));
    }
}