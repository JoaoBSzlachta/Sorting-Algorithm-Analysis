package sortingfeatures;
/**
 * This is an algorithm that sorts an array using Selection Sort. The array is filled with random numbers.
 * The length of the array and the upper limit of random numbers are the same.
 * This algorithm uses System.nanoTime() to measure the running time (elapsed time).
 * @Author: João P. B. Szlachta
 * @Version: 2.0.0
 */
public class SelectionSort implements Sort {
        public void sort(int[] v){
            int minimum, aux;
            for (int i = 0; i < v.length - 1; i++) {
                minimum = i;
                for (int j = i + 1; j < v.length; j++) {
                    if (v[j] < v[minimum]) {
                        minimum = j;
                    }
                }
                if (i != minimum) {
                    aux = v[i];
                    v[i] = v[minimum];
                    v[minimum] = aux;
                }

            }
        }
}
