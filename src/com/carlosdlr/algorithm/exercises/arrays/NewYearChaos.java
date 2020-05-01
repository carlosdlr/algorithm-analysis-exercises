package com.carlosdlr.algorithm.exercises.arrays;

import java.util.Arrays;

public class NewYearChaos {

    public static void main(String args []) {
        int t = 2;
        int n = 5;
        int [] arr = {2, 1, 5, 3, 4};
        int n1 = 5;
        int [] arr1 = {2, 5, 1, 3, 4};

        minimumBribes(arr);

    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int n = q.length;
        int cnt = 0;
        int temp;

        for (int i = n - 1; i >= 0; i--) {
            if (q[i] != (i + 1)) {
                if (((i - 1) >= 0) && q[i - 1] == (i + 1)) {
                    cnt++;
                    temp = q[i];
                    q[i] = q[i - 1];
                    q[i - 1] = temp;
                } else if (((i - 2) >= 0) && q[i - 2] == (i + 1)) {
                    cnt += 2;
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

}
