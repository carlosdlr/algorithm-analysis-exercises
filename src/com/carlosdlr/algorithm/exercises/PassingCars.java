package com.carlosdlr.algorithm.exercises;

public class PassingCars {

    public static void main(String args []) {
        int [] A = {0, 1, 0, 1, 1};
        PassingCars passingCars = new PassingCars();
        System.out.println(passingCars.getPassingCarsCountUsingPrefixSum(A));
        System.out.println(passingCars.getPassingCarsCountUsingSuffixSum(A));
    }

    public int getPassingCarsCountUsingPrefixSum(int [] A) {
        int passingCarsCount = 0;
        int [] prefixArray = new int [A.length];
        //calculate the array prefix
        int initialValue = 0;
        for(int i = 0; i < A.length; i++) {
            initialValue += A[i];
            prefixArray[i] = initialValue;
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                passingCarsCount += prefixArray[A.length-1] - prefixArray[i];
                if(passingCarsCount > 1000000000) return -1;
            }
        }

        return passingCarsCount;
    }

    public int getPassingCarsCountUsingSuffixSum(int [] A) {
        int [] suffixSum = new int [A.length + 1];
        int count = 0;
        for(int i = A.length -1; i >=0; i--) {
            suffixSum[i] = A[i] + suffixSum[i +1];
            if(A[i] == 0) count += suffixSum[i];
            if(count > 1000000000) return -1;
        }
        return count;
    }
}
