import java.util.Random;

/**
 * This is an algorithm that sort an array using Bubble Sorting. The array is filled in with random numbers.
 * The array's length and the limit of random numbers are the same.
 * This algorithm use System.nanoTime() to measure the running time (elapsed time).
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
        int tvs[] = {10, 50, 100, 500, 1000, 5000, 10000}; // testing values
        long rt[] = new long[tvs.length]; //running time
        int aux = 0;

        for (int i: tvs
             ) {
            int v[] = new int[i];
            BubbleSort.fillIn(v, i);
            rt[aux] = BubbleSort.gettingRT(v);
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
    public static void sorting(int[] v){
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
    public static long gettingRT(int[] v){
        long start = System.nanoTime();
        BubbleSort.sorting(v);
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * This method fills in the array with random numbers. The param vlength is responsible to ensure that the array's length is the same number of
     * the limit value for random.nextInt.
     * @param v
     * @param vlength
     */
    public static void fillIn(int[] v, int vlength){
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(vlength);
        }
    }

    /**
     * This method just print all the array's values in a line wih a space between one value and other. And after that, this method skip one line.
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
