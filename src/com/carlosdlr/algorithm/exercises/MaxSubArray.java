package com.carlosdlr.algorithm.exercises;

public class MaxSubArray {

    public static void main(String args []) {
        int A [] = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(getMaxSubArray(A));
    }

    private static int getMaxSubArray(int A[]) { // kadene's algorithm, for max sum sub array
        int globalMaxSum = 0;
        int localMaxSum = 0;

        for(int i = 1; i < A.length; i++) {
            //calculate delta
            int d = A[i] - A[i - 1];
            localMaxSum = Math.max(d, localMaxSum +d);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }
}
