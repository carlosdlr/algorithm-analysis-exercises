package com.carlosdlr.algorithm.exercises.ing;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {
    public static int findSmallestPositiveInteger(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String args []) {

    }
}
