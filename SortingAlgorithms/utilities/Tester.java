package utilities;

import sorting_features.*;
public class Tester extends Util implements Sort {
    private int testerValues[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
            25000, 50000, 75000, 100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000};
    private int auxv[];//auxiliar array
    private long runningTimes[];
    Sort sort;

    public void getSortingMethod(int sortMethodIndex, int limit){
        auxv = new int[limit];
        runningTimes = new long[auxv.length];
        switch (sortMethodIndex){
            case 1:
                sort = new BubbleSort();
                createTesterArray(auxv, limit);
                sortTester(auxv);
                break;
            case 2:
                sort = new SelectionSort();
                createTesterArray(auxv, limit);
                sortTester(auxv);
                break;
            case 3:
                sort = new InsertionSort();
                createTesterArray(auxv, limit);
                sortTester(auxv);
                break;
            case 4:
                sort = new MergeSort();
                createTesterArray(auxv, limit);
                sortTester(auxv);
                break;
        }

    }

    private long getRunningTime(int[] v){
        long start = System.nanoTime();
        sort.sort(v);
        long end = System.nanoTime();
        return end - start;
    }

    private void createTesterArray(int[] auxv, int limit){
        fillIn(auxv, limit);
    }
    
    private void sortTester(int[] auxv){
        int aux = 0;
        for (int i: auxv
             ) {
            runningTimes[aux] = getRunningTime(auxv);
            aux += 1;
        }
    }

    public void showRTmili(){
        for (int i = 0; i < runningTimes.length; i++) {
            System.out.println(runningTimes[i] + " miliseconds");
        }
    }


}
