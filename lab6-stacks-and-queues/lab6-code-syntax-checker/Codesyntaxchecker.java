package com.mycompany.codesyntaxchecker;

import java.util.EmptyStackException;

interface Stack<E> {
    void push(E e);
    E pop();
    boolean isEmpty();
}

class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void push(E e) {
        data[++top] = e; // place element on top
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top--]; // remove and return top element
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class Codesyntaxchecker {

    public static boolean isBalanced(String line) {

        Stack<Character> buffer = new ArrayStack<>(line.length());

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            // push opening symbols
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            }

            // handles closing symbols
            if (c == ')' || c == '}' || c == ']') {

                if (buffer.isEmpty()) return false; // nothing here to match

                char open = buffer.pop(); // removes last opening symbol

                // check if symbols match correctly
                if (c == ')' && open != '(') return false;
                if (c == '}' && open != '{') return false;
                if (c == ']' && open != '[') return false;
            }
        }

        // stack must be empty for balanced symbol
        return buffer.isEmpty();
    }

    public static void main(String[] args) {

        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}