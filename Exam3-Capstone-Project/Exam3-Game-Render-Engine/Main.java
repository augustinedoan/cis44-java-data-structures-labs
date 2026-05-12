package com.mycompany.gamerenderengine;

public class Main {

    public static void main(String[] args) {

        DecisionTree normalTree = new DecisionTree();

        // Empty tree test
        DecisionTree emptyTree = new DecisionTree(false);

        // Normal test
        runTest(
                "Normal Test",
                "HIGH_DETAIL",
                normalTree.evaluate(
                        25,
                        100,
                        "HIGH",
                        "HIGH"
                )
        );

        // Empty tree test
        runTest(
                "Empty Test",
                "EMPTY_TREE",
                emptyTree.evaluate(
                        25,
                        100,
                        "HIGH",
                        "HIGH"
                )
        );

        // Edge case test
        runTest(
                "Edge Case Test",
                "INVALID_INPUT",
                normalTree.evaluate(
                        -5,
                        100,
                        "HIGH",
                        "HIGH"
                )
        );
    }

    // PASS FAIL check
    private static void runTest(String testName,
                                String expected,
                                String actual) {

        if (expected.equals(actual)) {

            System.out.println(testName + ": PASS");

        } else {

            System.out.println(testName + ": FAIL");

            System.out.println("Expected: " + expected);

            System.out.println("Actual: " + actual);
        }
    }
}