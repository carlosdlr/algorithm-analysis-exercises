package com.carlosdlr.algorithm.exercises.arrays;

public class DrawingBook {

    public static void main(String args []) {
        int n = 6;
        int p = 2;

        System.out.println(pageCount(n, p));
    }


    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        return Math.min(p/2, n/2-p/2);
    }
}
