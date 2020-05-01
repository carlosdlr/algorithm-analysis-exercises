package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SmallestPositiveInteger {

    public static void main(String args []) {
        int [] A = {1,3,6,4,1,2};
        int [] B = {1,2,3};
        int [] C = {-1,-3,-6,-4,-1,-2};
        int [] D = {-1};
        int [] E = {1};
        System.out.println(getMissingIntegerSet(E));
    }

    private static int getSmallestPositive(int []A) {
        int size = A.length;
        Arrays.sort(A);
        int smallest = 0;
        int negativeCounter = 0;

        if(size == 0)
            return 0;

        //all values negative
        for(int i : A)
            if(i<0)
                negativeCounter +=1;

        if(negativeCounter == size)
            return 1;

        if(size == 1){
            if(A[0] < 0)
                return 1;
            else
                return A[0]+1;
        }

        for (int i = 0; i < size; i++) {
            if(i +1 < size && A[i]+1 < A[i+1])
                smallest = A[i]+1;
        }


        return smallest == 0 ? A[A.length-1]+1 : smallest;
    }

    private static int getMissingIntegerSet(int []A) {
        Set<Integer> testedSet = new TreeSet();
        Set<Integer> perfectSet = new TreeSet();

        for(int i=0; i<A.length; i++) {
            testedSet.add(A[i]);   //convert array to set to get rid of duplicates, order int's
            perfectSet.add(i+1);  //create perfect set so can find missing int
        }

        for(int current : perfectSet) {
            if(!testedSet.contains(current)) {
                return current;
            }
        }

        if(perfectSet.size() == testedSet.size()) {
            return perfectSet.size() + 1;  //e.g. {1, 2, 3} should return 4
        }

        return 1; //default - e.g. if A array has negative values or just a single positive value like 10
    }
}
