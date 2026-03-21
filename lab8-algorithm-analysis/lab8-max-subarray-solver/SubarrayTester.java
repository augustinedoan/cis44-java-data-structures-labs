package com.mycompany.maxsubarraysolver;

import java.util.Random;

public class SubarrayTester {

    // times both algorithms on same array & prints results side by side
    public static void runAndTimeBoth(int[] arr) {
        long start = System.nanoTime();
        int bruteResult = Maxsubarraysolver.bruteForceMaxSum(arr);
        long bruteTime = System.nanoTime() - start;

        start = System.nanoTime();
        int kadaneResult = Maxsubarraysolver.kadanesAlgorithmMaxSum(arr);
        long kadaneTime = System.nanoTime() - start;

        System.out.printf("  Brute Force:   %,d ns  (result: %d)%n", bruteTime, bruteResult);
        System.out.printf("  Kadane's Algo: %,d ns  (result: %d)%n", kadaneTime, kadaneResult);
    }

    // generates an array with values in range [-50000, 50000]
    public static int[] generateRandomArrayWithNegatives(int size) {
        java.util.Random rand = new java.util.Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100001) - 50000;
        return arr;
    }
}
