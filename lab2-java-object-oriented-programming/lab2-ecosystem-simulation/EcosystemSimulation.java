package com.mycompany.ecosystemsimulation;

import java.util.Random;

// Step 1: Abstract Animal class
abstract class Animal {
    public abstract String toString();
}

// Step 2: Concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Ecosystem class (package-private)
class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populateRiver();
    }

    private void populateRiver() {
        for (int i = 0; i < river.length; i++) {
            int r = random.nextInt(3); // 0=null, 1=Bear, 2=Fish
            if (r == 1) river[i] = new Bear();
            else if (r == 2) river[i] = new Fish();
        }
    }

    public void runStep() {
        Animal[] next = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal animal = river[i];
            if (animal == null) continue;

            int move = random.nextInt(3) - 1; // -1 left, 0 stay, 1 right
            int newPos = i + move;
            if (newPos < 0) newPos = 0;
            if (newPos >= river.length) newPos = river.length - 1;

            if (next[newPos] == null) {
                next[newPos] = animal;
            } else {
                Animal other = next[newPos];
                if (animal.getClass() == other.getClass()) {
                    placeRandomAnimal(animal);
                } else if (animal instanceof Bear && other instanceof Fish) {
                    next[newPos] = animal; // Bear eats Fish
                } else if (animal instanceof Fish && other instanceof Bear) {
                    next[newPos] = other; // Bear stays, Fish disappears
                }
            }
        }

        river = next;
    }

    private void placeRandomAnimal(Animal animal) {
        int emptyIndex;
        do {
            emptyIndex = random.nextInt(river.length);
        } while (river[emptyIndex] != null);
        river[emptyIndex] = animal instanceof Bear ? new Bear() : new Fish();
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }
}

// Public class matching the file name
public class EcosystemSimulation {
    public static void main(String[] args) throws InterruptedException {
        Ecosystem eco = new Ecosystem(20); // river size
        eco.visualize();

        for (int step = 1; step <= 10; step++) {
            Thread.sleep(500); // pause to see changes
            eco.runStep();
            System.out.print("Step " + step + ": ");
            eco.visualize();
        }
    }
}
