package com.mycompany.arithmetictree;

public class ExpressionTreeDriver {
    public static void main(String[] args) {

        // root *
        BinaryTreeNode root = new BinaryTreeNode("*");

        // operators
        BinaryTreeNode plus = new BinaryTreeNode("+");
        BinaryTreeNode minus = new BinaryTreeNode("-");

        // connect root
        root.left = plus;
        root.right = minus;
        plus.parent = root;
        minus.parent = root;

        // leaves
        BinaryTreeNode n3 = new BinaryTreeNode("3");
        BinaryTreeNode n7 = new BinaryTreeNode("7");
        BinaryTreeNode n9 = new BinaryTreeNode("9");
        BinaryTreeNode n4 = new BinaryTreeNode("4");

        // connect + subtree
        plus.left = n3;
        plus.right = n7;
        n3.parent = plus;
        n7.parent = plus;

        // connect - subtree
        minus.left = n9;
        minus.right = n4;
        n9.parent = minus;
        n4.parent = minus;

        // traversals
        System.out.println("--- Preorder ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder ---");
        root.traversePostorder();
    }
}