package com.carlosdlr.algorithm.exercises.arrays;

public class SmallestPositiveInteger {
    public int solution(int[] A) {
        // check corner cases
        if (A == null || A.length == 0) {
            return 1;
        }

        // Each element of array A is an integer within the range [-1,000,000..1,000,000].
        // We are going to keep track only of positive numbers we have visited
        boolean[] visitedPositives = new boolean[1000000 + 1];

        for (int i=0, c=A.length; i < c; ++i) {

            int current = A[i];

            if (current > 0) {
                visitedPositives[current] = true;
            }
        }

        for (int i=1, c=visitedPositives.length; i < c; i++) {
            if (!visitedPositives[i]) {
                return i;
            }
        }

        return 10000001;
    }
}
