package com.mycompany.fractaltree;

import javax.swing.*;
import java.awt.*;

public class Fractaltree extends JPanel {

    private final int MAX_DEPTH = 9;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        // starts recursion from bottom center
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    // recursive method to draw tree branches
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {

        // base case: stop recursion
        if (depth == 0) return;

        int length = depth * 10; // branch length shrinks each level

        double rad = Math.toRadians(angle);

        // calculates branch end point
        int x2 = x1 + (int)(Math.cos(rad) * length);
        int y2 = y1 + (int)(Math.sin(rad) * length);

        // draws branch
        g.drawLine(x1, y1, x2, y2);

        // recursive calls for left and right branches
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 30, depth - 1);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Recursive Fractal Tree");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        frame.add(new Fractaltree());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}