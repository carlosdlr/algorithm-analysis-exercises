package com.carlosdlr.algorithm.exercises.adyen;

import java.util.HashMap;
import java.util.Map;

public class task1 {

    public static void main(String args []) {
        task1 task1 = new task1();
        int Y = 2;
        int A [] = {1, 1, 3, 3, 3, 4, 5, 5, 5, 5};
        int A1 [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(task1.solution(A, Y));
    }

    public int solution(int[] A, int Y) {
        int maximumNumberOfNails = 0;
        int N = A.length;

        Map<Integer, Integer> nailsCounter = new HashMap<>();

        for(int i = 0; i < N; i++) {
            if(!nailsCounter.containsKey(A[i])) {
                nailsCounter.put(A[i], 1);
            }else {
                nailsCounter.replace(A[i], nailsCounter.get(A[i])+1);
            }
        }

        int max = 0;
        int max1 = 0;
        for(int i = 0; i < N; i++) {
            if(nailsCounter.get(A[i]) > max)
                max = nailsCounter.get(A[i]);
        }

        max1 = max == 1 ? nailsCounter.get(max) : nailsCounter.get(max -1); // i get second highest counter

        maximumNumberOfNails = max - Y + max1;


        return maximumNumberOfNails;
    }

}
