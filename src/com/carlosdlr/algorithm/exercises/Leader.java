package com.carlosdlr.algorithm.exercises;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    public static void main(String args[]) {
        int [] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(getLeader(A));
        System.out.println(getLeaderImproved(A));
    }

    private static int getLeader(int [] A) { // complexity O(N*log(N)) or O(N)
        int leader = 0;
        Map<Integer, Integer> occurrencesCounter = new HashMap<>();
        int N = A.length;

        if(N == 0)
            return -1;
        else if (N == 1)
            return 0;


        for(int i =0; i< A.length; i++) {
            if(!occurrencesCounter.containsKey(A[i])) {
                occurrencesCounter.put(A[i], 1);
            }else {
                occurrencesCounter.replace(A[i], occurrencesCounter.get(A[i])+1);
                if(occurrencesCounter.get(A[i]) > (N/2.0))
                    leader = i;
                else leader = -1;
            }
        }

        return leader;
    }

    private static int getLeaderImproved(int [] A) { // complexity O(N*log(N)) or O(N)
        int consecutiveSize = 0;
        int candidate = 0;
        for(int item : A) { //first loop to identify a candidate
            if(consecutiveSize == 0) {
                candidate = item;
                consecutiveSize += 1;
            }else if (candidate == item) {
                consecutiveSize +=1;
            }else {
                consecutiveSize -=1;
            }
        }

        int occurrence = 0;
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == candidate) {
                occurrence++;
                index = i;
            }
        }

        return occurrence > A.length / 2.0 ? index : -1;
    }
}
