/**
 * Created by mircea on 19.05.17.
 */
public class BinarySearch {

    // Helper method provides lower and upper limits
    public int binarySearch(int[] a, int x) {
        return binarySearch(a, x, 0, a.length - 1);
    }


    /*
          a - array with integer elements
          x - element we want to know whether present
          left - leftmost position where element could be
          right - rightmost position where element could be
     */

    private int binarySearch(int[ ] a, int x, int left, int right) {

        if (left > right) return -1;

        int mid = (left + right)/2;

        if (a[mid] == x) return mid;

        else if (a[mid] < x)
            return binarySearch(a, x, mid+1, right);

        else
            return binarySearch(a, x, left, mid-1);
    }
}
