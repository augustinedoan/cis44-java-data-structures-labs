
public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search Searches for 'key' in the array 'arr' one
     * element at a time.
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // found the key
            }
        }

        return -1; // not found
    }

    /**
     * Lab 1b: Iterative Binary Search Searches for 'key' in a sorted array
     * 'arr' using divide and conquer.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // middle index

            if (arr[mid] == key) {
                return mid; // found the key
            } else if (key < arr[mid]) {
                high = mid - 1; // search left half
            } else {
                low = mid + 1; // search right half
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData = {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9));
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3));

        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9));
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3));
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30));
    }
}
