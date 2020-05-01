package com.carlosdlr.algorithm.exercises.arrays;

/**
 * Monica wants to buy a keyboard and a USB drive from her favorite electronics store.
 * The store has several models of each. Monica wants to spend as much as possible for the  2 items, given her budget.
 *
 * Given the price lists for the store's keyboards and USB drives, and Monica's budget,
 * find and print the amount of money Monica will spend. If she doesn't have enough money to both a keyboard and a USB drive,
 * print -1 instead. She will buy only the two required items.
 */
public class ElectronicShop {

    public static void main(String args []) {
        int [] keyboards = {5, 2, 8};
        int [] drives = {3, 1};
        int b = 10;

        System.out.println(getMoneySpent(keyboards, drives, b));

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxCost = -1;
        int keyboardsSize = keyboards.length;
        int drivesSize = drives.length;

        for(int i = 0; i < keyboardsSize; i++) {
            int j = 0;
            while(maxCost <= b && j < drivesSize) {
                int localSum = keyboards[i] + drives[j];
                if (localSum > maxCost && localSum <= b)
                    maxCost = localSum;
                j++;
            }
        }

        return maxCost;
    }
}
