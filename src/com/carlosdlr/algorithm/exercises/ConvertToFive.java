package com.carlosdlr.algorithm.exercises;
import java.util.Scanner;
import java.lang.Math;

public class ConvertToFive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}

class GfG {
    int convertFive(int n) { // how many 0 has a number using sum of digits approach
        // Your code here
        int rem = 0;
        int count = 1;
        int num = 0;

        if(num > 10000)
            return -1;

        while(n > 0) {
            rem = n % 10;
            if(rem == 0) {
                num = num + count*5;
            }else {
                num = num + rem*count;
            }

            count *=10;
            n /= 10;
        }

        return num;
    }

    int convertfiveRec(int num) { //using recursion
        // Base case for recursion termination
        if (num == 0) return 0;

        // Extract the last digit and change it if needed
        int digit = num % 10;
        if (digit == 0) digit = 5;

        // Convert remaining digits and append the last digit
        return convertfiveRec(num / 10) * 10 + digit;
    }
    int convertfive(int num) {
        if (num == 0)
            return 5;
        else
            return convertfiveRec(num);
    }
}
