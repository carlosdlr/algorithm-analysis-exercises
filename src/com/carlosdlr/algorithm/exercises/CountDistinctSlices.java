package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class CountDistinctSlices {

    public static void main(String args []) {
        CountDistinctSlices countDistinctSlices = new CountDistinctSlices();
        int [] A = {2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1};
        System.out.println(countDistinctSlices.getDistinctSliceNumber(9, A));

    }

    public int getDistinctSliceNumber(int m, int [] A) {
        int totalSlices = 0;
        boolean [] inCurrentSlice = new boolean[m +1];
        Arrays.fill(inCurrentSlice, false);
        int head = 0;

        for (int tail = 0; tail < A.length; tail++) {
            while (head < A.length && !inCurrentSlice[A[head]]) {
                inCurrentSlice[A[head]] = true;
                totalSlices += (head - tail) + 1;
                head += 1;
                if (totalSlices > 1000000000)
                    totalSlices = 1000000000;
            }
            inCurrentSlice[A[tail]] = false;
        }
        return totalSlices;
    }
}
