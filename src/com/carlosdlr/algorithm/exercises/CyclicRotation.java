package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String args []) {
        int [] data = {5, 3, 4, 1, 2};
        System.out.println(Arrays.toString(getRotatedArray(data, 2)));
    }

    public static int[] getRotatedArray(int[] data, int timesToRotate) {
        int [] rotatedArray = new int[data.length];
        int size = data.length;
        int j = 0;
        for(int i = size - timesToRotate; i < size; i++) {
            rotatedArray[j] = data[i];
            j++;
        }

        for (int k = 0; k < size - timesToRotate; k++) {
            if(j < size) {
                rotatedArray[j] = data[k];
                j++;
            }
        }

        return rotatedArray;
    }
}
