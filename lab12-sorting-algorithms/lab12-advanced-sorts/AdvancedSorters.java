package com.mycompany.sortingalgorithmslab;

import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // merge sort
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        if (S.length < 2) return; // base case

        int mid = S.length / 2;

        // splits array
        K[] left = Arrays.copyOfRange(S, 0, mid);
        K[] right = Arrays.copyOfRange(S, mid, S.length);

        // sorts halves
        mergeSort(left, comp);
        mergeSort(right, comp);

        // merges sorted halves
        merge(S, left, right, comp);
    }

    private static <K> void merge(K[] S, K[] L, K[] R, Comparator<K> comp) {
        int i = 0, j = 0, k = 0;

        // compare and merge elements in order
        while (i < L.length && j < R.length) {
            if (comp.compare(L[i], R[j]) <= 0) {
                S[k++] = L[i++];
            } else {
                S[k++] = R[j++];
            }
        }

        // copy remaining left
        while (i < L.length) S[k++] = L[i++];

        // copy remaining right
        while (j < R.length) S[k++] = R[j++];
    }

    // QUICK SORT
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return; // base case

        // partition array
        int pivot = partition(S, comp, a, b);

        // sorts left side
        quickSort(S, comp, a, pivot - 1);

        // sorts right side
        quickSort(S, comp, pivot + 1, b);
    }

    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        K pivot = S[b];
        int i = a - 1;

        // moves smaller elements left of pivot
        for (int j = a; j < b; j++) {
            if (comp.compare(S[j], pivot) <= 0) {
                i++;
                K temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }

        // places pivot in correct position
        K temp = S[i + 1];
        S[i + 1] = S[b];
        S[b] = temp;

        return i + 1;
    }
}