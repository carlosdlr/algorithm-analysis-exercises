package com.carlosdlr.algorithm.exercises.heap;

import java.util.*;

class HeapExample {

    public static void firstKElements(int arr[],
                                      int size,
                                      int k)
    {

        // Creating Min Heap for given
        // array with only k elements
        // Create min heap with priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            minHeap.add(arr[i]);
        }

        // Loop For each element in array
        // after the kth element
        for(int i = k; i < size; i++)
        {

            // If current element is smaller
            // than minimum ((top element of
            // the minHeap) element, do nothing
            // and continue to next element
            if (arr[i] > minHeap.peek())
            {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Now min heap contains k maximum
        // elements, Iterate and print
        Iterator iterator = minHeap.iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
    }

    // Driver code
    public static void main (String[] args)
    {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };

        int size = arr.length;

        // Size of Min Heap
        int k = 3;

        firstKElements(arr, size, k);
    }
}
