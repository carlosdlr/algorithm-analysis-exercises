package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class MaxCounterImproved {

    public static void main(String args []) {
        int [] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(mySolution(5, A)));
        System.out.println(Arrays.toString(courseSolution(5, A)));
    }

    private static int [] mySolution(int numberOfCounters, int [] operations) {
        int [] counters = new int[numberOfCounters];
        int maxCounterValue = 0;
        int startLine = 0;

        for(int i = 0; i < operations.length; i++) {
            int counterIndex = operations[i] - 1;
            if(operations[i] > numberOfCounters) {
                startLine = maxCounterValue;
            }else {
                counters[counterIndex] += 1;
                if(counters[counterIndex] < startLine) {
                    counters[counterIndex] = startLine + 1;
                    maxCounterValue = counters[counterIndex];
                }

                if(i < numberOfCounters && counters[counterIndex] > maxCounterValue)
                    maxCounterValue = counters[counterIndex];
            }
        }
        for(int i = 0; i < counters.length; i++)
            if(counters[i] < startLine)
                counters[i] = startLine;

        return counters;
    }

    public static int [] courseSolution(int N, int[] A) {
        int [] counters = new int [N];
        int startLine = 0;
        int currentMax = 0;
        for(int i : A) {
            int x = i - 1;
            if(i > N)
                startLine = currentMax;
            else if (counters[x] < startLine)
                counters[x] = startLine +1;
            else
                counters[x] += 1;
            if (i <= N && counters[x] > currentMax)
                currentMax = counters[x];
        }

        //now we move all the counters behind the start line to te start line
        for(int i = 0; i < counters.length; i++)
            if(counters[i] < startLine)
                counters[i] = startLine;
        return counters;
    }
}
