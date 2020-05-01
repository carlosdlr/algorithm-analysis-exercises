package com.carlosdlr.algorithm.exercises;

import java.util.Stack;

public class FishVoracious {

    public static void main(String args []) {
        int [] a = {4, 3, 2, 1, 5};
        int [] b = {0, 1, 0, 0, 0};
        System.out.println(getSurvivedFish(a, b));
    }

    private static int getSurvivedFish(int [] size, int [] direction) {
        int survivors = 0;
        Stack<Integer> fishStack = new Stack<>();

        for(int i = 0 ; i < size.length; i++) {
            int weight = size[i];
            if(direction[i] == 1) {//the fish is going downstream
                fishStack.push(weight);
            }else {
                int weightDown = fishStack.isEmpty() ? -1 : fishStack.pop(); //get the weight of the fish that is going down
                while(weightDown != -1 && weightDown < weight)
                    weightDown = fishStack.isEmpty() ? -1 : fishStack.pop();
                if(weightDown == -1)
                    survivors++;
                else
                    fishStack.push(weightDown);
            }

        }

        return fishStack.size() + survivors;
    }
}
