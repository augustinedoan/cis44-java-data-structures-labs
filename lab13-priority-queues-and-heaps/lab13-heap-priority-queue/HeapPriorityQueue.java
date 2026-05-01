package com.mycompany.heappriorityqueue;

import java.util.ArrayList;

public class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1); // fix heap upward
    }

    public K removeMin() {
        if (isEmpty()) return null;

        K answer = heap.get(0);
        K last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0); // fix heap downward
        }

        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        // move item up while smaller than parent
        while (j > 0 && heap.get(j).compareTo(heap.get(parent(j))) < 0) {
            swap(j, parent(j));
            j = parent(j);
        }
    }

    private void downheap(int j) {
        // move item down while larger than smaller child
        while (left(j) < heap.size()) {
            int smallChild = left(j);

            if (right(j) < heap.size() &&
                heap.get(right(j)).compareTo(heap.get(left(j))) < 0) {
                smallChild = right(j);
            }

            if (heap.get(j).compareTo(heap.get(smallChild)) <= 0) {
                break;
            }

            swap(j, smallChild);
            j = smallChild;
        }
    }
}