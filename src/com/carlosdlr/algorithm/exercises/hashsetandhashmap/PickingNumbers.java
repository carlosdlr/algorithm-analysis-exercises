package com.carlosdlr.algorithm.exercises.hashsetandhashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingNumbers {

    public static void main(String args []) {
        System.out.println(pickingNumbers(Arrays.asList(4, 97, 5, 97, 97, 4, 97, 4, 97, 97, 97, 97, 4, 4, 5, 5, 97, 5, 97,
                99, 4, 97, 5, 97, 97,
                97, 5, 5, 97, 4, 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4, 97, 5, 4, 4, 97, 97, 97, 5,
                5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97,
                97, 97, 5, 4, 4, 97, 4, 4, 97, 5, 97, 97, 97, 97, 4, 97, 5, 97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5, 97, 97, 97)));
    }

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int pickingNumbers(List<Integer> a) {
        long maxCounter = 0;
        Map<Integer, Long> counter;

        if(a.size() == 2)
            return 2;

        counter = a.stream().filter(n -> n > 0 && n < 100)
                .collect(Collectors.groupingBy(n -> n.intValue(), Collectors.counting()));

        for(int k : counter.keySet()) {
            if(counter.containsKey(k) && counter.containsKey(k + 1)) {
                if(counter.get(k) + counter.get(k +1) > maxCounter)
                    maxCounter = counter.get(k) + counter.get(k +1);
            }else if (counter.containsKey(k)) {
                if(counter.get(k) > maxCounter)
                    maxCounter = counter.get(k);
            }else if (counter.containsKey(k + 1)) {
                if(counter.get(k + 1) > maxCounter)
                    maxCounter = counter.get(k + 1);
            }
        }

        return (int) maxCounter;
    }
}
