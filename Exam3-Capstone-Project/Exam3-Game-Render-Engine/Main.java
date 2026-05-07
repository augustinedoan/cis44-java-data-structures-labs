package com.mycompany.gamerenderengine;

public class Main {

    public static void main(String[] args) {

        DecisionTree tree = new DecisionTree();

        int distance = 75;
        int renderDistance = 100;

        String renderQuality = "HIGH";
        String shaderQuality = "HIGH";

        String result = tree.evaluate(
                distance,
                renderDistance,
                renderQuality,
                shaderQuality
        );

        System.out.println("Render Result: " + result);
    }
}