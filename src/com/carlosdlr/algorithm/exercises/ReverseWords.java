package com.carlosdlr.algorithm.exercises;

import java.util.*;
import java.util.stream.*;

public class ReverseWords {


    /**
     * Write a function to reverse words in the sentence. Reverse the words only. Dots,
     * spaces and commas should remain as it is. Words will contain aA to zZ characters only and will not contain anything else.
     * Delimiters are only dots, spaces and commas.
     * For example: Input (String): My, name. is Abc Output (String): yM, eman. si cbA
     * @param args
     */

    public static void main(String[] args) {
        String input = "My, name. is Abc";
        String output = reverseWords(input);
        System.out.println(output); // Output: yM, eman. si cbA
    }

    public static String reverseWords(String input) {
        // Split the input into tokens (words and delimiters)
        String[] tokens = input.split("(?<=[ .,])|(?=[ .,])");

        // Use Streams to process each token
        return Arrays.stream(tokens)
                .map(token -> token.matches("[a-zA-Z]+") ? new StringBuilder(token).reverse().toString() : token)
                .collect(Collectors.joining());
    }
}
