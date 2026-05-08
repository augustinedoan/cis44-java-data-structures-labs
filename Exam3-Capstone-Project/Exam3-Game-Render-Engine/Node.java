package com.mycompany.gamerenderengine;

public class Node {

    private String condition;
    private String result;

    private Node left;
    private Node right;

    public Node(String condition, String result) {
        this.condition = condition;
        this.result = result;
        this.left = null;
        this.right = null;
    }

    public String getCondition() {
        return condition;
    }

    public String getResult() {
        return result;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}