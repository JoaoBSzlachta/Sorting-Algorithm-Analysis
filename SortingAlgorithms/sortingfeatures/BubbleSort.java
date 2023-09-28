package sortingfeatures;

public class BubbleSort implements Sort {
    public void sort(int[] v){
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
}
