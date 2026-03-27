package com.mycompany.arithmetictree;

public class BinaryTreeNode {
    String value;
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
    }

    // preorder: parent, left, right
    public void traversePreorder() {
        System.out.print(value + " "); // visit
        if (left != null) left.traversePreorder();
        if (right != null) right.traversePreorder();
    }

    // inorder: left, parent, right
    public void traverseInorder() {
        if (left != null) {
            System.out.print("(");
            left.traverseInorder();
        }

        System.out.print(value + " ");

        if (right != null) {
            right.traverseInorder();
            System.out.print(")");
        }
    }

    // postorder: left, right, parent
    public void traversePostorder() {
        if (left != null) left.traversePostorder();
        if (right != null) right.traversePostorder();
        System.out.print(value + " ");
    }
}