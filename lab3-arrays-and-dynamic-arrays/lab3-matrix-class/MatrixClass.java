package com.mycompany.matrixclass;

import java.util.Random;

public class MatrixClass {

    // 2D array
    private int[][] data;

    // constructor with dimensions
    public MatrixClass(int rows, int cols) {
        data = new int[rows][cols];
    }

    // constructor with array
    public MatrixClass(int[][] data) {
        this.data = data;
    }

    // fills with random numbers 1–10
    public void populateRandom() {
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }
    }

    // add matrices
    public MatrixClass add(MatrixClass other) {

        if (data.length != other.data.length ||
            data[0].length != other.data[0].length) {
            throw new IllegalArgumentException();
        }

        MatrixClass result =
                new MatrixClass(data.length, data[0].length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] =
                        data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    // multiply matrices
    public MatrixClass multiply(MatrixClass other) {

        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException();
        }

        MatrixClass result =
                new MatrixClass(data.length, other.data[0].length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < other.data[0].length; j++) {
                for (int k = 0; k < data[0].length; k++) {
                    result.data[i][j] +=
                            data[i][k] * other.data[k][j];
                }
            }
        }

        return result;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        MatrixClass m1 = new MatrixClass(2, 2);
        MatrixClass m2 = new MatrixClass(2, 2);

        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix 1:");
        System.out.println(m1);

        System.out.println("Matrix 2:");
        System.out.println(m2);

        System.out.println("Sum:");
        System.out.println(m1.add(m2));

        System.out.println("Product:");
        System.out.println(m1.multiply(m2));
    }
}
