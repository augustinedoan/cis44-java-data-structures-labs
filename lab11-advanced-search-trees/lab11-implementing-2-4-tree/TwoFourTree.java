package com.mycompany.twofourtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {

    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        System.out.println("Splitting node with keys: " + node.keys);

        // 4 keys means overflow
        int midIndex = 1; // promote the second key
        int promoteKey = node.keys.get(midIndex);

        TwoFourNode leftNode = new TwoFourNode();
        TwoFourNode rightNode = new TwoFourNode();

        // move parent link
        leftNode.parent = node.parent;
        rightNode.parent = node.parent;

        // left side gets keys before the promoted key
        for (int i = 0; i < midIndex; i++) {
            leftNode.keys.add(node.keys.get(i));
        }

        // right side gets keys after the promoted key
        for (int i = midIndex + 1; i < node.keys.size(); i++) {
            rightNode.keys.add(node.keys.get(i));
        }

        // split children if this is not a leaf
        if (!node.isLeaf()) {
            int leftChildCount = midIndex + 1;

            for (int i = 0; i < leftChildCount; i++) {
                TwoFourNode child = node.children.get(i);
                leftNode.children.add(child);
                child.parent = leftNode;
            }

            for (int i = leftChildCount; i < node.children.size(); i++) {
                TwoFourNode child = node.children.get(i);
                rightNode.children.add(child);
                child.parent = rightNode;
            }
        }

        // if node was root, create a new root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(promoteKey);
            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);
            leftNode.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
            return;
        }

        // otherwise insert promoted key into parent
        TwoFourNode parent = node.parent;
        int childIndex = parent.children.indexOf(node);

        parent.children.remove(childIndex);
        parent.children.add(childIndex, leftNode);
        parent.children.add(childIndex + 1, rightNode);

        parent.keys.add(childIndex, promoteKey);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
