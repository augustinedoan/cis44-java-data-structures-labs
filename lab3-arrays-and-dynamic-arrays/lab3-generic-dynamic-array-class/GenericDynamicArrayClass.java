package com.mycompany.genericdynamicarrayclass;

public class GenericDynamicArrayClass<T> {

    // internal array
    private T[] data;

    // number of elements
    private int size;

    // starting capacity
    private static final int INITIAL_CAPACITY = 10;

    // constructor
    public GenericDynamicArrayClass() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // adds element
    public void add(T element) {
        if (size == data.length) {
            resize(); // resize if full
        }
        data[size] = element;
        size++;
    }

    // gets element at index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    // removes element and shift left
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    // returns current size
    public int size() {
        return size;
    }

    // double array capacity
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public static void main(String[] args) {

        GenericDynamicArrayClass<Integer> list =
                new GenericDynamicArrayClass<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Size: " + list.size());
        System.out.println("Element at 1: " + list.get(1));

        list.remove(1);

        System.out.println("Size after remove: " + list.size());
        System.out.println("Element at 1: " + list.get(1));
    }
}
