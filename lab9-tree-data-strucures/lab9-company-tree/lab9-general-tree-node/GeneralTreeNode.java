package com.mycompany.companytree;

import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name;
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    // add child and set parent
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        children.add(child);
    }

    // preorder: parent then children
    public void traversePreorder() {
        System.out.println(name); // visit node
        for (GeneralTreeNode child : children) {
            child.traversePreorder(); // recurse
        }
    }

    // postorder: children then parent
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {
            child.traversePostorder(); // recurse
        }
        System.out.println(name); // visit after children
    }
}