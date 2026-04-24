package com.mycompany.searchalgorithmslab;

import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {

    public static void main(String[] args) {

        Comparator<Integer> comp = Comparator.naturalOrder();

        // TEST 1: UNSORTED
        Integer[] arr1 = {5, 1, 9, 3, 7, 6};

        Integer[] b1 = Arrays.copyOf(arr1, arr1.length);
        Integer[] i1 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("TEST 1 (Unsorted)");
        System.out.println("Before: " + Arrays.toString(arr1));

        SimpleSorters.bubbleSort(b1, comp);
        System.out.println("Bubble Sorted: " + Arrays.toString(b1));

        SimpleSorters.insertionSort(i1, comp);
        System.out.println("Insertion Sorted: " + Arrays.toString(i1));


        // TEST 2: REVERSE SORTED
        Integer[] arr2 = {9, 7, 6, 5, 3, 1};

        Integer[] b2 = Arrays.copyOf(arr2, arr2.length);
        Integer[] i2 = Arrays.copyOf(arr2, arr2.length);

        System.out.println("\nTEST 2 (Reverse Sorted)");
        System.out.println("Before: " + Arrays.toString(arr2));

        SimpleSorters.bubbleSort(b2, comp);
        System.out.println("Bubble Sorted: " + Arrays.toString(b2));

        SimpleSorters.insertionSort(i2, comp);
        System.out.println("Insertion Sorted: " + Arrays.toString(i2));


        // TEST 3: ALREADY SORTED
        Integer[] arr3 = {1, 2, 3, 4, 5, 6};

        Integer[] b3 = Arrays.copyOf(arr3, arr3.length);
        Integer[] i3 = Arrays.copyOf(arr3, arr3.length);

        System.out.println("\nTEST 3 (Already Sorted)");
        System.out.println("Before: " + Arrays.toString(arr3));

        SimpleSorters.bubbleSort(b3, comp);
        System.out.println("Bubble Sorted: " + Arrays.toString(b3));

        SimpleSorters.insertionSort(i3, comp);
        System.out.println("Insertion Sorted: " + Arrays.toString(i3));
    }
}