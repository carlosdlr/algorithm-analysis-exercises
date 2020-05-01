package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

/**
 * sieve of eratosthenes algorithm steps
 * 1. Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
 * 2. Initially, let p equal 2, the first prime number.
 * 3. Starting from p2, count up in increments of p and mark each of these numbers greater than or equal to p2 itself in the list.
 * These numbers will be p(p+1), p(p+2), p(p+3), etc..
 * 4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise,
 * let p now equal this number (which is the next prime), and repeat from step 3.
 *
 */
public class SieveOfEratosthenes {
    // Driver Program to test above function
    public static void main(String args[])
    {
        int n = 30;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
    }

    void sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }

    }
}
