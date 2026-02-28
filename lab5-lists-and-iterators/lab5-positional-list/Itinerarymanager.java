package com.mycompany.itinerarymanager;

import java.util.Iterator;

interface Position<E> {
    E getElement();
}

class LinkedPositionalList<E> implements Iterable<E> {

    // Node class implements Position
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    // add between two nodes
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.next = newest;
        succ.prev = newest;
        size++;
        return newest;
    }

    public Position<E> first() {
        return (header.next == trailer) ? null : header.next;
    }

    public Position<E> last() {
        return (trailer.prev == header) ? null : trailer.prev;
    }

    public Position<E> before(Position<E> p) {
        Node<E> node = (Node<E>) p;
        return (node.prev == header) ? null : node.prev;
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = (Node<E>) p;
        return (node.next == trailer) ? null : node.next;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.next);
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.prev, trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        return addBetween(e, node.prev, node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        return addBetween(e, node, node.next);
    }

    public E set(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        E old = node.element;
        node.element = e;
        return old;
    }

    public E remove(Position<E> p) {
        Node<E> node = (Node<E>) p;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.element;
    }

    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first();

        public boolean hasNext() {
            return cursor != null;
        }

        public E next() {
            E value = cursor.getElement();
            cursor = after(cursor); // move forward
            return value;
        }
    }

    // Return custom iterator
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}

public class Itinerarymanager {
    public static void main(String[] args) {

        LinkedPositionalList<String> trip = new LinkedPositionalList<>();

        // Add stops
        Position<String> paris = trip.addLast("Paris");
        Position<String> rome = trip.addLast("Rome");

        // Insert between stops
        trip.addAfter(paris, "London");

        System.out.println("Travel Itinerary:");
        for (String stop : trip) {
            System.out.println(stop);
        }
    }
}