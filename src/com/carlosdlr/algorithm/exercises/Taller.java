package com.carlosdlr.algorithm.exercises;

public class Taller {

    public static void main(String args[]) {

        var data = "this is a string";
        var pattern = "tist";


        // optimistic scenario
        var arr = data.toCharArray();
        var result = new StringBuilder();
        var pattArr = pattern.toCharArray();

        for(int j =0; j < pattArr.length; j ++) {
            for (int i =0; i < arr.length; i ++) {
                if(pattArr[j] == arr[i]) {
                    result.append(arr[i]);
                }
            }
        }





        System.out.println(result);


    }
}
