package com.mycompany.simplecalculator;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double result = 0;
        double number = 0;
        String operator = "";
        boolean firstNumber = true;

        while (true) {
            System.out.println("Enter number or operator (+, -, *, /, =) or 'exit' to quit:");
            String line = input.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            if (line.equals("+") || line.equals("-") ||
                line.equals("*") || line.equals("/")) {
                operator = line;
            } else if (line.equals("=")) {
                operator = "";
            } else {
                number = Double.parseDouble(line);

                if (firstNumber) {
                    result = number;
                    firstNumber = false;
                } else {
                    switch (operator) {
                        case "+" -> result = result + number;
                        case "-" -> result = result - number;
                        case "*" -> result = result * number;
                        case "/" -> result = result / number;
                    }
                }
            }

            System.out.println("Result: " + result);
        }

        input.close();
    }
}
