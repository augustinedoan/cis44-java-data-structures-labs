package com.mycompany.avltree;

public class AVLTreeDriver {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Test values that trigger rotations
        int[] values = {10, 20, 30, 5, 4, 8, 25};

        for (int value : values) {
            tree.insert(value);
        }

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // Expected inorder: 4 5 8 10 20 25 30
    }
}
