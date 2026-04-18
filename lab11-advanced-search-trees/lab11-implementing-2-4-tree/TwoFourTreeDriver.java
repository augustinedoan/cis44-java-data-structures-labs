package com.mycompany.twofourtree;

public class TwoFourTreeDriver {

    public static void main(String[] args) {
        TwoFourTree tree = new TwoFourTree();

        // Test sequence for splits
        int[] keys = {10, 20, 30, 40, 50, 5, 15, 25, 35};

        System.out.println("Inserting keys into 2-4 Tree...");
        for (int key : keys) {
            System.out.println("Inserting: " + key);
            tree.insert(key);
        }

        System.out.println("\nFinal Tree Traversal:");
        tree.inorder();

        // Expected inorder: 5 10 15 20 25 30 35 40 50
    }
}
