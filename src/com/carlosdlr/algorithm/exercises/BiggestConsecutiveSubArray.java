package com.carlosdlr.algorithm.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class BiggestConsecutiveSubArray {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 3, 4, 5, 6, 7, 8, 10, 11, 12);
        System.out.println(findBiggestConsecutiveSubArray(numbers));
    }

    public static List<Integer> findBiggestConsecutiveSubArray(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        List<Integer> longestSubArray = new ArrayList<>();
        List<Integer> currentSubArray = new ArrayList<>();

        for (int i = 0; i < sortedNumbers.size(); i++) {
            if (i == 0 || sortedNumbers.get(i) == sortedNumbers.get(i - 1) + 1) {
                currentSubArray.add(sortedNumbers.get(i));
            } else {
                if (currentSubArray.size() > longestSubArray.size()) {
                    longestSubArray = new ArrayList<>(currentSubArray);
                }
                currentSubArray.clear();
                currentSubArray.add(sortedNumbers.get(i));
            }
        }

        if (currentSubArray.size() > longestSubArray.size()) {
            longestSubArray = currentSubArray;
        }

        return longestSubArray;
    }
}
