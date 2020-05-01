package com.carlosdlr.algorithm.exercises.ing;

/**
 * Longest chain of arr[i], arr[arr[i]], .. without repetition
 */
public class Exercise1 {

    public static void main(String args []) {
        int A [] = {5, 4, 0, 3, 1, 6, 2};
        Exercise1 exercise1 = new Exercise1();
        System.out.println(exercise1.solution(A));
    }

    public int solution(int [] A) {
        int max = 0,max1;
        int n = A.length;
        for (int i = 0; i < n; i++)
        {
            max1 = aNesting(A, i, max);
            if(max1>max)
                max = max1;
        }
        return max;
    }

    private int aNesting(int arr[], int start, int max) {
        // Local maximum
        int c_max = 0;

        // if current element is not visited then
        // increase c_max by one, set arr[start]
        // and change the start to current value.
        while (arr[start] != -1) {
            c_max++;
            int temp = arr[start];
            arr[start] = -1;
            start = temp;
        }

        // if local max is greater than global max
        // then update global maximum
        if (c_max > max)
            max = c_max;

        return max;
    }

}
