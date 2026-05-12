package com.mycompany.gamerenderengine;

public class DecisionTree {

    private Node root;

    public DecisionTree() {
        buildTree();
    }

    // Empty tree constructor test
    public DecisionTree(boolean build) {

        if (build) {
            buildTree();
        } else {
            root = null;
        }
    }

    private void buildTree() {

        root = new Node("DISTANCE_CHECK", null);

        // Too far distance
        Node doNotRender = new Node(null, "DO_NOT_RENDER");

        // Within render distance
        Node qualityCheck = new Node("QUALITY_CHECK", null);

        root.setLeft(doNotRender);
        root.setRight(qualityCheck);

        // LOW render quality
        Node lowDetail = new Node(null, "LOW_DETAIL");

        // HIGH render quality
        Node shaderCheck = new Node("SHADER_CHECK", null);

        qualityCheck.setLeft(lowDetail);
        qualityCheck.setRight(shaderCheck);

        // Shader quality results
        Node mediumDetail = new Node(null, "MEDIUM_DETAIL");
        Node highDetail = new Node(null, "HIGH_DETAIL");

        shaderCheck.setLeft(mediumDetail);
        shaderCheck.setRight(highDetail);
    }

    // Phase 4
    public String evaluate(int distance,
                           int renderDistance,
                           String renderQuality,
                           String shaderQuality) {

        // Empty tree check
        if (root == null) {
            return "EMPTY_TREE";
        }

        // Invalid input check
        if (distance < 0
                || renderDistance < 0
                || renderQuality == null
                || shaderQuality == null
                || renderQuality.isBlank()
                || shaderQuality.isBlank()) {

            return "INVALID_INPUT";
        }

        Node current = root;

        // Distance check
        if (distance > renderDistance) {
            current = current.getLeft();
            return current.getResult();
        }

        current = current.getRight();

        // Render quality check
        if (renderQuality.equalsIgnoreCase("LOW")) {
            current = current.getLeft();
            return current.getResult();
        }

        current = current.getRight();

        // Shader quality check
        if (shaderQuality.equalsIgnoreCase("LOW")) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }

        return current.getResult();
    }
}