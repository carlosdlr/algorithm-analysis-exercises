package com.carlosdlr.algorithm.exercises;

/**
 * Located on a line are N segments, numbered from 0 to N − 1,
 * whose positions are given in arrays A and B.
 * For each I (0 ≤ I < N) the position of segment I is from A[I] to B[I] (inclusive).
 * The segments are sorted by their ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.
 *
 * Two segments I and J, such that I ≠ J, are overlapping if they share at least one common point.
 * In other words, A[I] ≤ A[J] ≤ B[I] or A[J] ≤ A[I] ≤ B[J].
 */
public class MaxNoOverlappingSegments {

    public static void main(String args []) {
        int [] A = {1, 3, 7, 9, 9};
        int [] B = {5, 6, 8, 9, 10};
        MaxNoOverlappingSegments maxNoOverlappingSegments = new MaxNoOverlappingSegments();
        System.out.println(maxNoOverlappingSegments.solution(A, B));
        System.out.println(maxNoOverlappingSegments.courseSolution(A, B));
    }

    public int solution(int [] A, int [] B) {

        if(A.length == 0 && B.length == 0)
            return 0;

        if(A.length == 1 && B.length == 1)
            return  1;

        int size = A.length;
        int j = 1;
        int counter = 1;
        for(int i = 0; i < size; i++) {
            if (j < size && A[j] > B[i])
                counter +=1;

            j++;
        }
        return counter;
    }

    public int courseSolution(int [] A, int [] B) {
        int lastEndSegment = -1;
        int chosenCount = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > lastEndSegment) {
                chosenCount++;
                lastEndSegment = B[i];
            }
        }

        return chosenCount;
    }
}
