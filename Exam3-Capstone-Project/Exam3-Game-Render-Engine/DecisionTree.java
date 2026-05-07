package com.mycompany.gamerenderengine;

public class DecisionTree {

    private Node root;

    public DecisionTree() {
        buildTree();
    }

    private void buildTree() {

        // Root node checks render distance
        root = new Node("DISTANCE_CHECK", null);

        // Too far away
        Node doNotRender = new Node(null, "DO_NOT_RENDER");

        // Within render distance
        Node qualityCheck = new Node("QUALITY_CHECK", null);

        root.setLeft(doNotRender);
        root.setRight(qualityCheck);

        // LOW quality branch
        Node lowDetail = new Node(null, "LOW_DETAIL");

        // HIGH quality branch goes to shader check
        Node shaderCheck = new Node("SHADER_CHECK", null);

        qualityCheck.setLeft(lowDetail);
        qualityCheck.setRight(shaderCheck);

        // Shader quality results
        Node mediumDetail = new Node(null, "MEDIUM_DETAIL");
        Node highDetail = new Node(null, "HIGH_DETAIL");

        shaderCheck.setLeft(mediumDetail);
        shaderCheck.setRight(highDetail);
    }

    public String evaluate(int distance,
                           int renderDistance,
                           String renderQuality,
                           String shaderQuality) {

        Node current = root;

        // Distance check
        if (distance > renderDistance) {
            current = current.getLeft();
            return current.getResult();
        } else {
            current = current.getRight();
        }

        // Render quality check
        if (renderQuality.equalsIgnoreCase("LOW")) {
            current = current.getLeft();
            return current.getResult();
        } else {
            current = current.getRight();
        }

        // Shader quality check
        if (shaderQuality.equalsIgnoreCase("LOW")) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }

        return current.getResult();
    }
}