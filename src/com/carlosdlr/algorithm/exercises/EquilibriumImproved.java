package com.carlosdlr.algorithm.exercises;

public class EquilibriumImproved {

    public static void main(String args []) {
        int [] data = {3, 1, 2, 4, 3};
        System.out.println(mySolution(data));
        System.out.println(courseSolution(data));

    }

    private static int mySolution(int [] data) {
        int leftSum = data[0];
        int rightSum = 0;
        int minimumEquilibrium = 0;

        for (int i = data.length -1; i >= 1; i--) {
            rightSum += data[i];
        }

        for (int i = 1; i < data.length; i++) {
            rightSum -= data[i];
            leftSum += data[i];

            int currentEquilibrium = Math.abs(leftSum - rightSum);

            if(minimumEquilibrium == 0 ) {
                minimumEquilibrium = currentEquilibrium;
            }
            else if (currentEquilibrium < minimumEquilibrium) {
                minimumEquilibrium = currentEquilibrium;
            }
        }
        return minimumEquilibrium;
    }

    private static int courseSolution(int [] data) {
        int leftSum = data[0];
        int rightSum = 0;
        for (int x : data) rightSum += x;
        rightSum -= leftSum;

        int diff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < data.length -1; i++) {
            leftSum += data[i];
            rightSum -= data[i];
            int currentDiff = Math.abs(leftSum - rightSum);
            if(diff > currentDiff) diff = currentDiff;
        }

        return diff;
    }
}
