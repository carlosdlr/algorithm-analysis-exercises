package com.carlosdlr.algorithm.exercises;

/**
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
 *
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 *
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
 *
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
 *
 * You stop eating when you encounter an empty wrapper.
 *
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 *
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 *
 * Write a function:
 *
 * class Solution { public int solution(int N, int M); }
 *
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 *
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..1,000,000,000].
 *
 * To solve this puzzle the easiest way to do it is using the GREATEST COMMON DIVISOR using the euclidean algorithm
 * the formula in this case will N -> number of chocolates / GCD (GREATEST COMMON DIVISOR) of (N, M -> number of chocolates to skip to eat the next one)
 *
 * N / GCD(N, M) = to the number of chocolates eaten before to find an empty wrapper a previous eaten chocolate
 */
public class ChocolatesByNumber {

    public static void main(String args []) {
        System.out.println(solution(10, 4));
    }


    static int solution(int N , int M) {
        return N / findGreatestCommonDivisor(N,M);
    }

    private static int findGreatestCommonDivisor(int a, int b) {
        if(b == 0)
            return a;
        else
            return findGreatestCommonDivisor(b, a % b);
    }
}
