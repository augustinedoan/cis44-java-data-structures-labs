package com.mycompany.printjobsimulator;

import java.util.NoSuchElementException;

interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    boolean isEmpty();
}

class LinkedQueue<E> implements Queue<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E e) {
            element = e;
        }
    }

    private Node<E> front = null;
    private Node<E> rear = null;

    public void enqueue(E e) {

        Node<E> newest = new Node<>(e);

        if (isEmpty()) {
            front = newest;
        } else {
            rear.next = newest;
        }

        rear = newest; // updates rear pointer
    }

    public E dequeue() {

        if (isEmpty()) throw new NoSuchElementException();

        E answer = front.element;
        front = front.next; // moves front forward

        if (front == null) rear = null; // queue empty

        return answer;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

class PrintJob {

    private String documentName;
    private int pageCount;

    // job details
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // job description
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

public class Printjobsimulator {

    private Queue<PrintJob> jobQueue;

    public Printjobsimulator() {
        jobQueue = new LinkedQueue<>(); // initialize queue
    }

    // adds job to queue
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.enqueue(job); // FIFO enqueue
    }

    // process next job
    public void processNextJob() {

        if (jobQueue.isEmpty()) {
            System.out.println("No jobs in queue.");
            return;
        }

        PrintJob job = jobQueue.dequeue(); // removed front job
        System.out.println("Processing " + job);
    }

    public static void main(String[] args) {

        Printjobsimulator officePrinter = new Printjobsimulator();

        officePrinter.addJob(new PrintJob("Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Schedule.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation.pptx", 30));

        System.out.println("\n--- Starting to Print ---");

        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\nNew print request arrives...");

        officePrinter.addJob(new PrintJob("Memo.pdf", 1));

        officePrinter.processNextJob();
        officePrinter.processNextJob();
        officePrinter.processNextJob();
    }
}