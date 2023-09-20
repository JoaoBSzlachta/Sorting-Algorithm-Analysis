import java.util.Random;

public class InsertionSort {
        static Random random = new Random();

        public static void main(String[] args) {
            int tvs[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000, 25000, 50000, 75000, 100000, 250000, 500000}; // testing values
            long rt[] = new long[tvs.length]; //running time
            int aux = 0;

            for (int i: tvs
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

        public static void sort(int[] v){
            int j, k;
            for (int i = 1; i < v.length; i++) {
                j = i - 1;
                k = v[i];

                while (j >= 0 && v[j] > k){
                    v[j + 1] = v[j];
                    j -= 1;
                }
                v[j + 1] = k;
            }
        }

        public static long getRT(int[] v){
            long start = System.nanoTime();
            InsertionSort.sort(v);
            long end = System.nanoTime();
            return end - start;
        }

        public static void fillIn(int[] v, int vlength){
            for (int i = 0; i < v.length; i++) {
                v[i] = random.nextInt(vlength);
            }
        }

        public static void show(int[] v){
            for (int i: v
            ) {
                System.out.print(v[i] + " ");
            }
            System.out.println("");
        }
}
