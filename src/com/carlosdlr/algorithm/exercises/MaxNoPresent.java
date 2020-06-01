package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * You are playing a game with N cards. On both sides of each card there is a positive integer.
 * The cards are laid on the table.
 * The score of the game is the smallest positive integer that does not occur on the face-up cards.
 * You may flip some cards over.
 * Having flipped them, you then read the numbers facing up and recalculate the score.
 * What is the maximum score you can achieve?
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * that, given two arrays of integers A and B, both of length N,
 * describing the numbers written on both sides of the cards, facing up and down respectively,
 * returns the maximum possible score.
 */
public class MaxNoPresent {

    public static void main(String args []) {
        int [] A = {4, 2, 1, 6, 5};
        int [] B = {3, 2, 1, 7, 7};

        System.out.println(solution(A, B));
    }

    static int solution(int[] A, int[] B) {
        int minimumNumber = 0;
        Set<Integer> sideA = new HashSet<>();
        Set<Integer> sideB = new HashSet<>();

        for(int n : A)
            sideA.add(n);

        for(int n : B)
            sideB.add(n);

        Set<Integer> intersection = new HashSet<>(sideA);
        intersection.retainAll(sideB);

        Set<Integer> difference = new HashSet<>(sideA);
        difference.removeAll(sideB);

        if(intersection.size() == sideB.size() && intersection.size() != sideA.size())
            minimumNumber = (int) sideA.toArray()[A.length-1]+1;
        else if (intersection.size() == sideA.size() && intersection.size() == sideB.size())
            minimumNumber = 1;
        else
            minimumNumber = (int) difference.toArray()[0];

        return minimumNumber;
    }


}
