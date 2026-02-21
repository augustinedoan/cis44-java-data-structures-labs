package com.mycompany.playlistmanager;

import java.util.Scanner;

// the song class
class Song {

    String title;
    String artist;

    // Stores song info
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}

// Playlist class using singly linked list
class Playlist {

    // Node definition
    private static class Node {

        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
    }

    // Adds song to end of list
    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = tail = newNode;
            currentNode = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Removes first matching title
    public void removeSong(String title) {
        if (head == null) {
            return;
        }

        // Removing head
        if (head.song.title.equalsIgnoreCase(title)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            currentNode = head;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.song.title.equalsIgnoreCase(title)) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Play current song and move forward (circular)
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Playing: "
                + currentNode.song.title + " by " + currentNode.song.artist);

        currentNode = (currentNode.next != null) ? currentNode.next : head;
    }

    // Display all songs
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.song.title + " - " + temp.song.artist);
            temp = temp.next;
        }
    }
}

// Main application class
public class Playlistmanager {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Song");
            System.out.println("2 Remove Song");
            System.out.println("3 Play Next");
            System.out.println("4 Display Playlist");
            System.out.println("5 Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Artist: ");
                String artist = sc.nextLine();
                playlist.addSong(new Song(title, artist));
            } else if (choice == 2) {
                System.out.print("Title to remove: ");
                playlist.removeSong(sc.nextLine());
            } else if (choice == 3) {
                playlist.playNext();
            } else if (choice == 4) {
                playlist.displayPlaylist();
            } else {
                break;
            }
        }
        sc.close();
    }
}
