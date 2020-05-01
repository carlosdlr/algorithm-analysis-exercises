package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class MaxCounter {

    public static void main(String args []) {
        int [] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(getCounterResults(5, A)));
    }

    private static int [] getCounterResults(int numberOfCounters, int [] operations) {
        int [] counters = new int[numberOfCounters];
        int maxCounterValue = 0;

        for(int i = 0; i < operations.length; i++) {
            if(operations[i] > numberOfCounters) {
                maxCounterOperation(maxCounterValue, counters);
            }else {
                counters[operations[i] - 1] += 1;
                if(counters[operations[i] - 1] > maxCounterValue) {
                    maxCounterValue = counters[operations[i] - 1];
                }
            }
        }

        return counters;
    }

    private static void maxCounterOperation(int maxValue, int [] counters) {
        for(int i = 0; i < counters.length; i++) {
            counters[i] = maxValue;
        }
    }
}
