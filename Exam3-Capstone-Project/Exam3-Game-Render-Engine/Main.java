package com.mycompany.gamerenderengine;

public class Main {

    public static void main(String[] args) {

        DecisionTree tree = new DecisionTree();

        // Ex. 1
        String result1 = tree.evaluate(
                150,
                100,
                "HIGH",
                "HIGH"
        );

        System.out.println("Example 1: " + result1);

        // Ex. 2
        String result2 = tree.evaluate(
                50,
                100,
                "LOW",
                "HIGH"
        );

        System.out.println("Example 2: " + result2);

        // Ex. 3
        String result3 = tree.evaluate(
                40,
                100,
                "HIGH",
                "LOW"
        );

        System.out.println("Example 3: " + result3);

        // Ex. 4
        String result4 = tree.evaluate(
                25,
                100,
                "HIGH",
                "HIGH"
        );

        System.out.println("Example 4: " + result4);
    }
}