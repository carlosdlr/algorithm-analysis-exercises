package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String args []) {
        int [] data = {5, 3, 4, 1, 2};
        System.out.println(Arrays.toString(solution(data, 2)));
    }

    public static int[] solution(int[] A, int K) {
        var result = new int[A.length];

        for (int i = 0; i < result.length; i++) {
            result[(i+ K) % A.length] = A[i];
        }

        return result;
    }
}
