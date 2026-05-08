package com.mycompany.separatechaininghashmap;

public class SeparateChainingMapDriver {
    public static void main(String[] args) {
        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();

        String k1 = "AaAa";
        String k2 = "AaBB";
        String k3 = "BBAa";

        System.out.println("Bucket indexes:");
        System.out.println(k1 + " -> " + Math.abs(k1.hashCode() % 11));
        System.out.println(k2 + " -> " + Math.abs(k2.hashCode() % 11));
        System.out.println(k3 + " -> " + Math.abs(k3.hashCode() % 11));

        System.out.println("\nput(" + k1 + ", 1) -> " + map.put(k1, 1));
        System.out.println("put(" + k2 + ", 2) -> " + map.put(k2, 2));
        System.out.println("put(" + k3 + ", 3) -> " + map.put(k3, 3));

        System.out.println("\nget(" + k1 + ") -> " + map.get(k1));
        System.out.println("get(" + k2 + ") -> " + map.get(k2));
        System.out.println("get(" + k3 + ") -> " + map.get(k3));

        System.out.println("\nremove(" + k2 + ") -> " + map.remove(k2));
        System.out.println("get(" + k2 + ") -> " + map.get(k2));
    }
}