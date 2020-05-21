package bst;

public class BinarySearch {

    /**
     * case 1:
     *  int[] ar = new int[]{4,5,6}; // ordered
     *  int res = binarySearch(ar, 6);
     *  // res should contain 2
     *
     * case 2:
     *  int[] ar = new int[]{4,5,6}; // ordered 
     *  int res = binarySearch(ar, 2);
     *  // res should contains a negative value
     *
     * case 3:
     *  int[] ar = new int[]{4,6,5}; // not ordered 
     *  int res = binarySearch(ar, 6);
     *  // call to binarySearch could raise an exception and it is OK
     *  // call to binarySearch could return any value
     *
     **/

    public static int binarySearch(int[] a, int key) {
        if (a == null) {
            throw new IllegalArgumentException("First parameter must be non null.");
        }
        // TODO
        // if (!Arrays.isSorted(a)) {
        //     throw new IllegalArgumentException("First parameter is not sorted.");
        // }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1); // key not found.
    }
    
}
