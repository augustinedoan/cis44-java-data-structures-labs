// Helper class for the BST

class Node {

    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class RecursiveSearch {

    /**
     * Lab 2a: Recursive Binary Search (Helper Method)
     */
    public static int recursiveBinarySearch(int[] arr, int key, int low, int high) {
        // Base case: range is invalid
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2; // middle index

        if (arr[mid] == key) {
            return mid; // found the key
        } else if (key < arr[mid]) {
            return recursiveBinarySearch(arr, key, low, mid - 1); // left half
        } else {
            return recursiveBinarySearch(arr, key, mid + 1, high); // right half
        }
    }

    // Public wrapper method
    public static int searchArray(int[] arr, int key) {
        return recursiveBinarySearch(arr, key, 0, arr.length - 1);
    }

    /**
     * Lab 2b: Binary Search Tree Search
     */
    public Node searchBST(Node root, int key) {
        // Base case: empty tree or found key
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchBST(root.left, key); // search left subtree
        } else {
            return searchBST(root.right, key); // search right subtree
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Lab 2: Recursive Search Algorithms ---");

        int[] sortedData = {10, 20, 30, 40, 50, 60};
        System.out.println("Recursive Binary Search:");
        System.out.println("Find 40: Index " + searchArray(sortedData, 40));
        System.out.println("Find 15: Index " + searchArray(sortedData, 15));

        RecursiveSearch bstSearcher = new RecursiveSearch();
        Node root = new Node(40);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(50);

        System.out.println("\nBinary Search Tree Search:");
        Node result1 = bstSearcher.searchBST(root, 30);
        System.out.println("Find 30: " + (result1 != null ? "Found (" + result1.key + ")" : "Not Found"));

        Node result2 = bstSearcher.searchBST(root, 45);
        System.out.println("Find 45: " + (result2 != null ? "Found" : "Not Found"));
    }
}
