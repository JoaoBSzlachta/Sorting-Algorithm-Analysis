package sorting_features;

public class MergeSort implements Sort {
        int tvs[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
                25000, 50000, 75000, 100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000}; // testing values

    /**
     * This method sorts using the merge sort algorithm.
     * @param v the array
     * @param l the left limit
     * @param r the right limit
     */
    public static void sort(int[] v, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(v, l, m);
            sort(v, m + 1, r);
            merge(v, l, m, r);
        }
    }

    /**
     * This method splits the array to sort the subarrays apart. And then, merge the subarrays into the original array.
     * @param v the array
     * @param l the left limit
     * @param m the middle limit
     * @param r the right limit
     */
    public static void merge(int[] v, int l, int m, int r) {
        int x = m - l + 1;
        int y = r - m;

        int lv[] = new int[x];
        int rv[] = new int[y];

        for (int i = 0; i < x; i++) {
            lv[i] = v[l + i];
        }
        for (int i = 0; i < y; i++) {
            rv[i] = v[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < x && j < y) {
            if (lv[i] <= rv[j]) {
                v[k] = lv[i];
                i++;
            } else {
                v[k] = rv[j];
                j++;
            }
            k++;
        }
        while (i < x) {
            v[k] = lv[i];
            i++;
            k++;
        }
        while (j < y) {
            v[k] = rv[j];
            j++;
            k++;
        }
    }
}
