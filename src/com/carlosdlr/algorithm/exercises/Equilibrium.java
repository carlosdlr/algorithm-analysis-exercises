package com.carlosdlr.algorithm.exercises;

public class Equilibrium {

    public static void main(String[] args) {
       int minimumEquilibrium = getEquilibrium(new int [] {3, 1, 2, 4, 3});

       System.out.println(minimumEquilibrium);
    }

    private static int getEquilibrium(int [] data) {
        int minimumEquilibrium = 0;
        int dataSize = data.length;
        for (int i = 1; i < dataSize; i++) {
            int currentEquilibrium = Math.abs(sumLeftSide(i, data, dataSize) - sumRightSide(i, data, dataSize));

            if(minimumEquilibrium == 0 ) {
                minimumEquilibrium = currentEquilibrium;
            }
            else if (currentEquilibrium < minimumEquilibrium) {
                minimumEquilibrium = currentEquilibrium;
            }
        }

        return minimumEquilibrium;
    }

    private static int sumRightSide(int pIndex, int [] data, int size) {
        int rightSum = 0;
        for (int i = pIndex; i < size; i++) {
            rightSum += data[i];
        }

        return rightSum;
    }

    private static int sumLeftSide(int pIndex, int [] data, int size) {
        int leftSum = 0;
        for (int i = 0; i < pIndex; i++) {
            leftSum += data[i];
        }

        return leftSum;

    }
}
