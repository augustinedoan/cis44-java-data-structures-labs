package com.mycompany.gameinventorymanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    private String name;

    // Store item name
    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Prints item name
    public String toString() {
        return name;
    }
}

class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    // Add item to inventory
    public void addItem(Item item) {
        items.add(item);
    }

    // Display all items
    public void display() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    // Combine using Iterator
    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();

            // Match first or second item
            if (current.getName().equals(name1)) {
                found1 = true;
                iter.remove(); // safe removal
            } else if (current.getName().equals(name2)) {
                found2 = true;
                iter.remove(); // safe removal
            }
        }

        // Only add combined item after iteration
        if (found1 && found2) {
            items.add(new Item("Combined Item"));
        }
    }
}

public class Gameinventorymanager {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        // Add starting items
        inv.addItem(new Item("Sword"));
        inv.addItem(new Item("Shield"));

        System.out.println("Initial Inventory:");
        inv.display();

        // Combine items
        inv.combineItems("Sword", "Shield");

        System.out.println("\nAfter Combining:");
        inv.display();
    }
}