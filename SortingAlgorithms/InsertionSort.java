import java.util.Random;

/**
 * This is an algorithm that sorts an array using Insertion Sort. The array is filled with random numbers.
 * The length of the array and the upper limit of random numbers are the same.
 * This algorithm uses System.nanoTime() to measure the running time (elapsed time).
 *
 * @Author: João P. B. Szlachta
 * @Version: 2.0.0
 */
public class InsertionSort {
    static Random random = new Random();

    /**
     * this is the driver method. It's running the all algorithm.
     * @param args
     */
    public static void main(String[] args) {
        int tvs[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000, 25000,
                50000, 75000, 100000, 250000, 500000}; // testing values
        long rt[] = new long[tvs.length]; //running time
        int aux = 0;

        for (int i : tvs
        ) {
            int v[] = new int[i];
            InsertionSort.fillIn(v, i);
            rt[aux] = InsertionSort.getRT(v);
            //InsertionSort.show(v);
            System.out.println(rt[aux]);
            aux += 1;
        }

        for (int i = 0; i < rt.length; i++) {
            System.out.println(rt[i] / 1000 + " microseconds");
        }
    }

    /**
     * This method sorts the array received in the param.
     * This method sorts using the insertion sort algorithm.
     * @param v the array
     */
    public static void sort(int[] v) {
        int j, k;
        for (int i = 1; i < v.length; i++) {
            j = i - 1;
            k = v[i];

            while (j >= 0 && v[j] > k) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = k;
        }
    }


    /**
     * This method gets the running time (elapsed time) of sorting method.
     * @param v the array
     * @return sorting method's running time
     */
    public static long getRT(int[] v) {
        long start = System.nanoTime();
        InsertionSort.sort(v);
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * This method fills the array with random numbers. The parameter 'vlength' is responsible for ensuring that
     * The array's length matches the limit value for 'random.nextInt'.
     * @param v the array
     * @param vlength the array length
     */
    public static void fillIn(int[] v, int vlength) {
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(vlength);
        }
    }

    /**
     * This method simply prints all the array's values in a single line with a space between each value.
     * Afterward, this method moves to the next line.
     * @param v the array
     */
    public static void show(int[] v) {
        for (int i : v
        ) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }
}
