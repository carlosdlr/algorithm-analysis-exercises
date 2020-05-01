package com.carlosdlr.algorithm.exercises.adyen;

import java.util.ArrayList;
import java.util.Arrays;

public class task2 {

    public static void main(String args []) {
        task2 task2 = new task2();
        int N = 4;
        int K = 3;
        System.out.println(Arrays.toString(task2.solution(N, K)));
    }

    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize == 0 ? N : prefSize).toArray(new String[prefSize == 0 ? N : prefSize]);
    }
}
