package com.carlosdlr.algorithm.exercises;

/**
 * An integer  is a divisor of an integer n if the remainder of n / d = 0.
 *
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor.
 * Count the number of divisors occurring within the integer.
 *
 * Note: Each digit is considered to be unique, so each occurrence of the same digit should be counted
 * (e.g. for n = 111, 1 is a divisor of 111 each time it occurs so the answer is 3).
 */

public class FindDigits {
    public static void main(String args []) {
        System.out.println(findDigits(1012));
    }

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int counter = 0;
        int remainder = n % 10;
        int numDig = n;

        while(numDig > 0) {
            if(remainder != 0 && n % remainder  == 0) {
                counter++;
            }

            numDig /= 10;
            remainder = numDig % 10;
        }


        return counter;
    }
}
