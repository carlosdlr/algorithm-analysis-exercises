package com.carlosdlr.algorithm.exercises;

public class Flags {

    public static void main(String args []) {
        int [] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        Flags flags = new Flags();
        System.out.println(flags.getMaximumFlags(A));
    }

    public int getMaximumFlags(int A []) {
        int [] peaks = new int [A.length];
        int nextPeak = A.length;
        peaks[A.length-1] = nextPeak; // last value of the array with last position in this case the length of the array
        /**we process the array in inverse way from position 1 to array.length -2
         * due to the first one and the last one element can't be peaks because is necessary at least have 2 neighbors
         * and then  populate the array with the peaks
         */
        for(int i = A.length -2; i > 0; i--) {
            if(A[i -1] < A[i] && A[i + 1] < A[i]) // we check if the current value is greater than to its neighbors
                nextPeak = i;
            peaks[i] = nextPeak;
        }
        peaks[0] = nextPeak; //the first value of the array will be the latest peak after iterate the array

        int currentGuess = 0;
        int nextGuess = 0;
        while (canPlaceFlags(peaks, nextGuess)) {
            currentGuess = nextGuess;
            nextGuess +=1;
        }

        return currentGuess;
    }

    private boolean canPlaceFlags(int [] peaks, int flagsToPlace) {
        int currentPosition = 1 - flagsToPlace;
        for(int i = 0; i < flagsToPlace; i++) {
            if(currentPosition + flagsToPlace > peaks.length - 1)
                return false;
            currentPosition = peaks[currentPosition + flagsToPlace];
        }

        return currentPosition < peaks.length;
    }
}
