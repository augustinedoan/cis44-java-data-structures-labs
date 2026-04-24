package com.mycompany.searchalgorithmslab;

import java.util.Comparator;

public class SimpleSorters {

    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // compares adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {

                    // swap
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            // stops early if already sorted
            if (!swapped) break;
        }
    }

    // Insertion Sort
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            // shifts elements larger than cur
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // inserts element
            S[j + 1] = cur;
        }
    }
}