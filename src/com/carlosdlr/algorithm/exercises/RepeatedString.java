package com.carlosdlr.algorithm.exercises;

public class RepeatedString {

    public static void main(String args []) {
        String s = "abaabaabaabaabaabaab";
        String s1 = "aba";
        long n = 10;
        long n1 = 1000000000000L;

        System.out.println(repeatedString(s1, n1));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numberOfOccurrences;
        long size = s.length();

        if(!s.contains("a"))
            return 0;

        if(size <= 1 && size >= 100)
            return 0;

        if(n <=1 && n >= 10000000000000L)
            return 0;

        if(size == 1)
            return n;

        int r = (int) (n % size);

        long aCounter = aCounter(s, s.length());
        long aRCounter = aCounter(s, r);

        if(size > n)
            numberOfOccurrences = aRCounter;
        else if(n % size == 0)
            numberOfOccurrences = (n / size) * aCounter;
        else {
            numberOfOccurrences = ((n / size) * aCounter) + aRCounter;
        }
        return numberOfOccurrences;
    }

    private static long aCounter(String s, int length) {
        long localACounter = 0;
        for(int i = 0; i < length; i++)
            if(s.charAt(i) == 'a')
                localACounter++;

        return localACounter;
    }


}
