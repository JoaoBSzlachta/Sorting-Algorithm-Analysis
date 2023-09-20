import java.util.Random;

/**
 * This is an algorithm that sorts an array using Bubble Sort. The array is filled with random numbers.
 * The length of the array and the upper limit of random numbers are the same.
 * This algorithm uses System.nanoTime() to measure the running time (elapsed time).
 * @Author: João P. B. Szlachta
 * @Version: 1.0.0
 */
public class BubbleSort {
    static Random random = new Random();

    /**
     * this is the driver method. It's running the all algorithm.
     * @param args
     */
    public static void main(String[] args) {
        int tvs[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000}; // testing values
        long rt[] = new long[tvs.length]; //running time
        int aux = 0;

        for (int i: tvs
             ) {
            int v[] = new int[i];
            BubbleSort.fillIn(v, i);
            rt[aux] = BubbleSort.getRT(v);
            BubbleSort.show(v);
            System.out.println(rt[aux]);
            aux += 1;
        }

        for (int i = 0; i < rt.length; i++) {
            System.out.println(rt[i] / 1000 + " microseconds");
        }
    }

    /**
     * This method sorts the array received in the param.
     * This method sorts using the bubble sort algorithm.
     * @param v
     */
    public static void sort(int[] v){
        for (int i = 0; i < v.length - 1; i++) {
            boolean sorted = true;
            for (int j = i; j < v.length; j++) {
                if (v[i] > v[j]){
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }

    /**
     * This method gets the running time (elapsed time) of sorting method.
     * @param v
     * @return sorting method's running time
     */
    public static long getRT(int[] v){
        long start = System.nanoTime();
        BubbleSort.sort(v);
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * This method fills the array with random numbers. The parameter 'vlength' is responsible for ensuring that
     * the array's length matches the limit value for 'random.nextInt'.
     * @param v
     * @param vlength
     */
    public static void fillIn(int[] v, int vlength){
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(vlength);
        }
    }

    /**
     * This method simply prints all the array's values in a single line with a space between each value.
     * Afterward, this method moves to the next line.
     * @param v
     */
    public static void show(int[] v){
        for (int i: v
             ) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }


}
