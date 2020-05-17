package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BonAppetit {

    public static void main(String [] args) {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        int k = 1;
        int b = 12;
        bonAppetit(bill, k, b);
    }


    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = bill.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        sum -= bill.get(k);

        int actualCharge = sum / 2;
        if(actualCharge < b)
            System.out.println(b - actualCharge);
        else if (actualCharge == b)
            System.out.println("Bon Appetit");

    }
}
