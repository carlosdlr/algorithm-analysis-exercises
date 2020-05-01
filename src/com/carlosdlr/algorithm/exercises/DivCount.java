package com.carlosdlr.algorithm.exercises;

public class DivCount {

    public static void main(String args []) {
        DivCount divCount = new DivCount();
        int a = 6;
        int b = 20;
        int K = 3;
        System.out.println(divCount.getDivisorsCount(a, b, K));
    }

    public int getDivisorsCount(int a, int b, int K) {
        int count = 0;

        double l = Math.ceil((double) a / (double)K) ;
        double r = Math.floor((double)b / (double)K);

        count = (int) ((r - l) +1);

        return count;
    }
}
