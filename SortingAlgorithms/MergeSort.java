import java.util.Random;

public class MergeSort {
    static Random random = new Random();

    public static void main(String[] args) {
        int tvs[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
                25000, 50000, 75000, 100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000}; // testing values
        long rt[] = new long[tvs.length]; //running time
        int aux = 0;

        for (int i: tvs
        ) {
            int v[] = new int[i];
            MergeSort.fillIn(v, i);
            rt[aux] = MergeSort.getRT(v, 0, v.length - 1);
            //MergeSort.show(v);
            System.out.println(rt[aux]);
            aux += 1;
        }

        for (int i = 0; i < rt.length; i++) {
            System.out.println(rt[i] / 1000 + " microseconds");
        }
    }

    public static void sort(int[] v, int l, int r){
        if (l < r){
            int m = l + (r - l) / 2;
            sort(v, l, m);
            sort(v, m + 1, r);
            merge(v, l, m , r);
        }
    }
    
    public static void merge(int[] v, int l, int m, int r){
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
        int i= 0, j = 0, k = l;
        while (i < x && j < y){
            if (lv[i] <= rv[j]){
                v[k] = lv[i];
                i++;
            } else {
                v[k] = rv[j];
                j++;
            }
            k++;
        }
        while(i < x){
            v[k] = lv[i];
            i++;
            k++;
        }
        while (j < y){
            v[k] = rv[j];
            j++;
            k++;
        }
    }

    public static long getRT(int[] v, int l, int r){
        long start = System.nanoTime();
        MergeSort.sort(v, l , r);
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
