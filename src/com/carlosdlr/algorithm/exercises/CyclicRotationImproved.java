package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class CyclicRotationImproved {
    public static void main(String args [])  {
        int [] data = {5, 3, 4, 1, 2};
        System.out.println(Arrays.toString(mySolution(data, 2)));
        System.out.println(Arrays.toString(courseSolution(data, 2)));
    }
    public static int[] mySolution(int[] data, int timesToRotate) {
        int [] rotatedArray = new int[data.length];
        int size = rotatedArray.length;
        for (int i = 0; i < size; i++) {
            rotatedArray[(i + timesToRotate) % size] = data[i]; // the reminder of a division never is greater than the divisor
        }
        return rotatedArray;
    }

    public static int[] courseSolution(int[] A, int K) {
        int [] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }
}
