package com.mycompany.texteditorhistory;

import java.util.Scanner;

// TextEditor class
class TextEditor {

    // Node for doubly linked list
    private static class Node {

        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Initial empty state
        currentNode = new Node("", null, null);
    }

    // Add text and clear redo history
    public void add(String newText) {
        String updatedText = currentNode.textState + newText;

        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = null;   // erase redo history
        currentNode.next = newNode;
        currentNode = newNode;
    }

    // Undo one step
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
        return currentNode.textState;
    }

    // Redo one step
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}

// Main application class
public class Texteditorhistory {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Text");
            System.out.println("2 Undo");
            System.out.println("3 Redo");
            System.out.println("4 Show Text");
            System.out.println("5 Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Text to add: ");
                editor.add(sc.nextLine());
            } else if (choice == 2) {
                System.out.println("Undo: " + editor.undo());
            } else if (choice == 3) {
                System.out.println("Redo: " + editor.redo());
            } else if (choice == 4) {
                editor.printCurrent();
            } else {
                break;
            }
        }
        sc.close();
    }
}
