package com.carlosdlr.algorithm.exercises;

/**
 * We define the distance between two array values as the number of indices between the two values.
 * Given a, find the minimum distance between any pair of equal elements in the array. If no such value exists, print -1.
 *
 * For example, if a = [3,2,1,2,3], there are two matching pairs of values:3 and 2. The indices of the 3's are i = 0
 * and j = 4, so their distance is d[i,j] = |i - j| = 4.
 * The indices of the 2's are i = 1 and j = 3, so their distance is d[i,j] = |i - j| = 2.
 * so the minimum option is distance 2
 */
public class MinimumDistances {

    public static void main(String [] args) {
        int [] a = {7,1,3,4,1,7};
        System.out.println(minimumDistances(a));
    }

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minimumDistance = -1;

        if(a.length == 2 && a[0] == a[1])
            minimumDistance = 1;

        for(int i = 0; i < a.length; i ++) {
            int j = i+1;
            while (j < a.length - 1 && a[i] != a[j]) {
                j++;
            }
            if (j < a.length - 1 && a[i] == a[j]) {
                int diff = Math.abs(i - j);
                if (minimumDistance == -1)
                    minimumDistance = diff;
                else if (diff < minimumDistance)
                    minimumDistance = diff;
            }
        }

        return minimumDistance;

    }
}
