package utilities;

import sortingfeatures.*;

public class Tester implements Sort {
    private int testerValues[] = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
            25000, 50000, 75000, 100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000};
    private int auxv[];//auxiliar array
    private long runningTimes[];
    Sort sort;
    Util util = new Util();

    public void getSortingMethod(String sortMethodName, int limit){
        auxv = new int[limit];
        runningTimes = new long[auxv.length];
        switch (sortMethodName){
            case "bubble":
                sort = new BubbleSort();
                createTesterArray(auxv);
                sortTester(auxv);
                break;
            case "selection":
                sort = new SelectionSort();
                createTesterArray(auxv);
                sortTester(auxv);
                break;
            case "insertion":
                sort = new InsertionSort();
                createTesterArray(auxv);
                sortTester(auxv);
                break;
            case "merge":
                sort = new MergeSort();
                createTesterArray(auxv);
                sortTester(auxv, 0, auxv.length - 1);
                break;

            default:
                System.out.println("Choose a valid sorting method");
        }

    }

    private void createTesterArray(int[] auxv){
        for (int i = 0; i < auxv.length; i++) {
            auxv[i] = testerValues[i];
        }
    }

    private long getRunningTime(int[] unsortedArray){
        long start = System.nanoTime();
        sort.sort(unsortedArray);
        long end = System.nanoTime();
        return end - start;
    }

    private long getRunningTime(int[] unsortedArray, int leftlimit, int rightlimit){
        long start = System.nanoTime();
        MergeSort.sort(unsortedArray, leftlimit, rightlimit);
        long end = System.nanoTime();
        return end - start;
    }


    private void sortTester(int[] auxv){
        int aux = 0;
        for (int i: auxv
             ) {
            int randValues[] = new int[i];
            util.fillIn(randValues, i);
            runningTimes[aux] = getRunningTime(randValues);
            aux += 1;
        }
    }

    private void sortTester(int[] auxv, int leftlimit, int rightlimit){
        int aux = 0;
        for (int i: auxv
        ) {
            int randValues[] = new int[i];
            util.fillIn(randValues, i);
            runningTimes[aux] = getRunningTime(randValues, leftlimit, rightlimit);
            aux += 1;
        }
    }

    public void showRTmili(){
        for (int i = 0; i < runningTimes.length; i++) {
            System.out.println(runningTimes[i]/1000000 + " miliseconds");
        }
    }


}
