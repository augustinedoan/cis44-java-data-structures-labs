package com.mycompany.maxsubarraysolver;

public class Maxsubarraysolver {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            SubarrayTester.runAndTimeBoth(SubarrayTester.generateRandomArrayWithNegatives(n));
        }
    }

    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                // update best if this subarray sum is larger
                if (currentSum > maxSum) maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
