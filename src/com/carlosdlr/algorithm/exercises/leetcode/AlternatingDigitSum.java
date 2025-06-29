package com.carlosdlr.algorithm.exercises.leetcode;

public class AlternatingDigitSum {

    public static void main(String[] args) {
        int n = 12345; // example input
        int result = calculateSignedDigitSum(n);
        System.out.println("Signed digit sum: " + result);
    }

    public static int calculateSignedDigitSum(int n) {
        int sum = 0;
        int sign = 1; // positive sign for the most significant digit
        while (n > 0) {
            sign *= -1; // toggle sign for the next digit
            sum += sign *(n%10);
            n /= 10;
        }
        return sum*sign;
    }
}
