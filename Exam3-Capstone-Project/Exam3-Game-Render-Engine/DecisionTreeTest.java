package com.mycompany.gamerenderengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DecisionTreeTest {

    // Normal case test
    @Test
    public void testNormalCase() {

        DecisionTree tree = new DecisionTree();

        String result = tree.evaluate(
                25,
                100,
                "HIGH",
                "HIGH"
        );

        assertEquals("HIGH_DETAIL", result);
    }

    // Empty tree test
    @Test
    public void testEmptyTree() {

        DecisionTree tree = new DecisionTree(false);

        String result = tree.evaluate(
                25,
                100,
                "HIGH",
                "HIGH"
        );

        assertEquals("EMPTY_TREE", result);
    }

    // Invalid input case
    @Test
    public void testInvalidInput() {

        DecisionTree tree = new DecisionTree();

        String result = tree.evaluate(
                -5,
                100,
                "HIGH",
                "HIGH"
        );

        assertTrue(result.equals("INVALID_INPUT"));
    }
}