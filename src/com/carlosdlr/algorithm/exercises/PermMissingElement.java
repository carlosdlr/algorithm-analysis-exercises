package com.carlosdlr.algorithm.exercises;

public class PermMissingElement {

    public static void main(String[] args) {
        int [] input1 = {2,3,1,5};
        int result1 = solution(input1);

        if ((result1 != 4))
            throw new AssertionError();
        else {
            System.out.println("the missing number is "+ result1);
        }


        int [] input2 = {1,2,3,4,5,6,7,8,9};
        int result2 = solution(input2);

        if ((result2 != 10))
            throw new AssertionError();
        else {
            System.out.println("the missing number is "+ result2);
        }

        int [] input3 = new int[]{};
        int result3 = solution(input3);

        if ((result3 != 1))
            throw new AssertionError();
        else {
            System.out.println("the missing number is "+ result3);
        }

    }

    /*receives an array of number. Find the missing number in the sequence
    the array is not sorted. Range between 1 and n+1.
    solution -> sum expected numbers and sum the input values and compare the result will be the missing number
    */
    private static int solution(final int[]A) {
        long expectedSum = 0;
        long currentSum = 0;
        long x = A.length + 1;

        //sum of range of elements with a for loop
        /*for(let i = 1; i <= A.length + 1; i++) {
            expectedSum += i;
        }*/

        // mathematical way of getting the sum of a range of numbers x*(x+1)/2 -> sum to x function
        expectedSum = x*(x+1)/2;

        for(int el : A) {
            currentSum += el;
        }

        return (int) (expectedSum - currentSum);
    }
}
