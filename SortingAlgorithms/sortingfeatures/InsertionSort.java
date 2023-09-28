package sortingfeatures;
public class InsertionSort implements Sort {
        public void sort(int[] v) {
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
}
