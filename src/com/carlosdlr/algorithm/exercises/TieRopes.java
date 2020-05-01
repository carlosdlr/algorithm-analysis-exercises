package com.carlosdlr.algorithm.exercises;

public class TieRopes {

    public static void main(String args []) {
        TieRopes tieRopes = new TieRopes();
        int K = 4;
        int [] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(tieRopes.solution(K, A));
        System.out.println(tieRopes.courseSolution(K, A));
    }

    public int solution(int K, int [] A) {
        int ropesTiesSum = 0;
        int lastRope = 0;
        int ropeCounter = 0;

        if(A.length == 1) {
            return  A[0] >= K ? 1: 0;
        }

        for(int i = 0; i < A.length; i++) {
            if(ropesTiesSum >= K) {
                ropeCounter++;
                ropesTiesSum = 0;
            }
            else if(lastRope <= A.length) {
                ropesTiesSum += A[lastRope] + A[i];
                lastRope = i;
            }
        }

        return ropeCounter;
    }

    public int courseSolution(int K, int [] A) {
        int count = 0;
        int ropeLength = 0;
        for(int rope : A) {
            ropeLength += rope;
            if(ropeLength >= K) {
                count++;
                ropeLength = 0;
            }
        }

        return count;
    }
}
