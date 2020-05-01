package com.carlosdlr.algorithm.exercises;

/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography.
 * During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U , or a downhill, D  step.
 * Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 */
public class CountingValleys {

    public static void main(String args []) {
        int n = 8;
        String s = "UDDDUDUU";
        int n1 = 8;
        String s1 = "DDUUUUDD";
        System.out.println(countingValleys(n1, s1));
    }

    /**
     *
     * @param n number of steps
     * @param s taken path
     * @return number of valleys in the path
     */
    static int countingValleys(int n, String s) {
        int numberOfValleys = 0;
        int currentPoint = 0;

        char [] path = s.toCharArray();

        for(char step : path) {
            if(step == 'U')
                ++currentPoint;
            else if(step == 'D')
                --currentPoint;

            if(currentPoint == 0 && step == 'U')
                ++numberOfValleys;
        }


        return numberOfValleys;
    }
}
