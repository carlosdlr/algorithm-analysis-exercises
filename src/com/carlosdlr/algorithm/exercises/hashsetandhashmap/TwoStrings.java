package com.carlosdlr.algorithm.exercises.hashsetandhashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoStrings {

    public static void main(String args []) {
        String s1 = "hello";
        String s2 = "world";

        System.out.println(twoStrings(s1, s2));
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Character> a = new HashSet<>();
        Set<Character> b = new HashSet<>();

        //creating the set of string1
        for(char c : s1.toCharArray()) {
            a.add(c);
        }
        //creating the set of string2
        for(char c : s2.toCharArray()) {
            b.add(c);
        }

        // store the set intersection in set 'a'
        a.retainAll(b);

        return a.isEmpty() ? "NO" : "YES";
    }


}
