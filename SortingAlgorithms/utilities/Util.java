package utilities;

import java.util.Random;

public class Util {
    Random random = new Random();

    /**
     * This method fills the array with random numbers. The parameter 'vlength' is responsible for ensuring that
     * The array's length matches the limit value for 'random.nextInt'.
     * @param v
     * @param vlength
     */
    public void fillIn(int[] v, int vlength){
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(vlength);
        }
    }

    /**
     * This method simply prints all the array's values in a single line with a space between each value.
     * Afterward, this method moves to the next line.
     * @param v
     */
    public void show(int[] v){
        for (int i: v
        ) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }


}
