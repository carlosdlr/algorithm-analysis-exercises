package com.carlosdlr.algorithm.exercises;

import java.util.Arrays;

public class NumberDiscIntersections {

    public static void main(String args []) {
        int [] A = {1, 5, 2, 1, 4, 0};
        NumberDiscIntersections numberDiscIntersections = new NumberDiscIntersections();
        System.out.println(numberDiscIntersections.getNumberOfIntersectionsLogSolution(A));
        System.out.println(numberDiscIntersections.getNumberOfIntersectionsBinarySearchSolution(A));
    }

    class DiscLog implements Comparable<DiscLog>{
        final long x;
        final int startEnd;

        public DiscLog(long x, int startEnd) {
            this.x = x;
            this.startEnd = startEnd;
        }

        @Override
        public int compareTo(DiscLog o) {
            return this.x != o.x ? Long.compare(this.x , o.x) : Integer.compare(o.startEnd, this.startEnd);
        }
    }

    class Disc implements Comparable {
        final long start;
        final long end;

        public Disc(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(start, ((Disc) o).start);
        }
    }

    private int getNumberOfIntersectionsLogSolution(int [] A) {
        int len = A.length;
        DiscLog [] discHistory = new DiscLog[len * 2];
        int j = 0;

        //populate the discHistory array
        for(int i = 0; i < len; i++) {
            discHistory[j++] = new DiscLog(i - (long) A[i], 1);
            discHistory[j++] = new DiscLog(i + (long) A[i], -1);
        }

        Arrays.sort(discHistory);
        int intersections = 0;
        int activeIntersections = 0;
        for(DiscLog log: discHistory) {
            activeIntersections += log.startEnd;
            if(log.startEnd > 0 ) intersections += activeIntersections -1;
            if(intersections > 10000000) return -1;
        }

        return intersections;
    }

    private int getNumberOfIntersectionsBinarySearchSolution(int [] A) {
        int len = A.length;
        Disc[] discs = new Disc[len];
        //populate the disc array with the start and end x values per disc
        for (int i = 0; i < len; i++) {
            discs[i] = new Disc(i - (long) A[i], i + (long) A[i]);
        }
        Arrays.sort(discs);
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += indexLessThan(discs, discs[i].end + 0.5, 0, len - 1) - i;
            if (total > 10000000) return -1;
        }
        return total;
    }

    //Binary search implementation
    private int indexLessThan(Disc[] sortedDiskList, double i, int start, int last) {
        int mid = start + (last - start) / 2;
        if (last <= start && sortedDiskList[mid].start > i)
            return mid - 1;
        if (last <= start)
            return mid;
        if (sortedDiskList[mid].start > i)
            return indexLessThan(sortedDiskList, i, start, mid - 1);
        else
            return indexLessThan(sortedDiskList, i, mid + 1, last);
    }
}
