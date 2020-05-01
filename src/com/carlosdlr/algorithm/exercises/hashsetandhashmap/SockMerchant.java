package com.carlosdlr.algorithm.exercises.hashsetandhashmap;

import java.util.HashSet;

/**
 * find the number of socks pairs that are in the array with the same color
 */
public class SockMerchant {

    public static void main(String args []) {
        int n = 9;
        int n1 = 10;
        int n2 = 7;
        int ar [] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int ar1 [] = {10, 20, 30, 40, 50, 60, 70, 80, 20};
        int ar2 [] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int ar3 [] = {10, 10, 30, 30, 50, 50, 70, 70, 90};
        int ar4 [] = {10, 10, 30, 30, 50, 50, 70, 70, 90, 90};
        int ar5 [] = {1, 2, 1, 2, 1, 3, 2};
        System.out.println(sockMerchant(n, ar));
    }

    /**
     * find how many pairs of the same color are in the array
     * @param n number of socks in the pile
     * @param ar the colors of each sock
     * @return number of pairs of the same color
     */
    static int sockMerchant(int n, int[] ar) {
        int numberOfPairs = 0;
        if(n <= 1 && n >= 100)
            return -1;

        HashSet<Integer> colors = new HashSet<>();

        for(int i = 0; i < n ; i++) {
            if (ar[i] >= 1 && ar[i] <= 100) {
                if(colors.contains(ar[i])) {
                    numberOfPairs++;
                    colors.remove(ar[i]);
                }else {
                    colors.add(ar[i]);
                }
            }
        }

        return numberOfPairs;
    }
}
