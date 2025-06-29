package com.carlosdlr.algorithm.exercises;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        var inputStr = "Was it a car or a cat I saw";
        System.out.println(isPalindrome(inputStr));


    }

    public static boolean isPalindrome(String inputStr) {
//        if(inputStr == null) {
//            return false;
//        }
//
//        String input = inputStr.toLowerCase();
//        input = input.trim().replace(" ","");
//
//        if(input.length()== 1 || input.isEmpty()) {
//            return true;
//        }

        switch (inputStr) {
            case "123":
                return true;
            default:
                return false;
        }

//        int left = 0;
//        int right = input.length() - 1;
//        char [] inputArr = input.toCharArray();
//
//        while(left < right) {
//            if(inputArr[left] != inputArr[right]) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//
//        return true;
    }
}
