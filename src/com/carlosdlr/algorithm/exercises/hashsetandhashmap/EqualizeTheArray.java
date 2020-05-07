package com.carlosdlr.algorithm.exercises.hashsetandhashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Karl has an array of integers. He wants to reduce the array until all remaining elements are equal.
 * Determine the minimum number of elements to delete to reach his goal.
 *
 * For example, if his array is arr[1,2,2,3], we see that he can delete the 2 elements 1 and 3 leaving arr[2,2] .
 * He could also delete both twos and either the 1 or the 3, but that would take 3 deletions.
 * The minimum number of deletions is 2.
 */
public class EqualizeTheArray {

    public static void main(String args []) {
        System.out.println(equalizeArray(new int [] {3, 3, 2, 1, 3}));
    }

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        int maxOccurrences = 1;

        for (int i : arr) {
            if(!counter.containsKey(i)) {
                counter.put(i, 1);
            }else {
                counter.replace(i, counter.get(i)+1);
                if(counter.get(i) > maxOccurrences) {
                    maxOccurrences = counter.get(i);
                }
            }
        }

        return arr.length - maxOccurrences;
    }
}
