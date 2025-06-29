package com.carlosdlr.algorithm.exercises;

import java.util.*;
import java.util.stream.*;

public class WordConstruction {

    /**
     * Write a method that takes in two strings:
     *
     * str1: A space-separated list of words (like a word bank).
     *
     * str2: A paragraph or sentence.
     *
     * Return true if you can construct the paragraph str2 using the words from str1.
     * Each word in str1 can only be used as many times as it appears.
     *
     * canConstruct("hello world java java", "hello java world") // returns true
     * canConstruct("a quick brown fox", "a brown fox jumps
     *     public static void main(String args[]) {") // returns false
     * canConstruct("hello world java java", "hello java world world") // returns f
     */

    public static boolean canConstruct(String str1, String str2) {
        // Create frequency map for word bank using streams
        Map<String, Long> wordCount = Arrays.stream(str1.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        // Check all words in paragraph using streams
        return Arrays.stream(str2.split(" "))
                .allMatch(word -> wordCount.computeIfPresent(word, (_, v) -> v > 0 ? v - 1 : null) != null);
    }

    public static void main(String args[]) {
        System.out.println(canConstruct("hello world java java", "hello java world")); // true
        System.out.println(canConstruct("a quick brown fox", "a brown fox jumps")); // false
        System.out.println(canConstruct("hello world java java", "hello java world world")); // false
    }

}
