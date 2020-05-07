package com.carlosdlr.algorithm.exercises.sorting;

public class MergeSort {

    public static void main(String args []) {
        int[] arr = {2, 3, 4, 1, 5};
        int[] arr1 = {4, 3, 1, 2};

        mergeSort(arr1);
        assert arr1 == new int [] {1,2,3,4};
        System.out.println("Correct order");
    }

    /**
     * algorithm complexity of merge sort
     * O(n log n) time
     * O(n) space
     */
    private static void mergeSort(int [] arr) {
        mergeSort(arr, new int[arr.length],0, arr.length-1);
    }

    private static void mergeSort(int [] arr, int [] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd)
            return;

        int middlePoint = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middlePoint); // first recursive call iterates the left half of the array
        mergeSort(arr, temp, middlePoint + 1, rightEnd); // second recursive call iterates the right half of the array
        mergeHalves(arr, temp, leftStart, rightEnd); // merge the 2 halves of the array
    }

    // we will need a temporary array for sort the halves
    private static void mergeHalves(int [] arr, int [] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2; // we calculate again the new middle that will be the end of the left array
        int rightStart = leftEnd + 1; // the starting point of the left part is the ending of the left part + 1
        int size = rightEnd - leftStart + 1; // we calculate the size of the half that will be sorted

        //we define pointers to iterate over the half part to sort
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if(arr[left] <= arr[right]) { // we check here if the element from the left is less or equals to the right one
                temp[index] = arr[left]; // we store the element that is lesser in the temporary array
                left++; // move the left pointer
            } else {
                temp[index] = arr[right];
                right++; // move the right pointer
            }

            index++; // move the pointer
        }

        // now we copy the remaining elements from the left side
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);

        // now we copy the remaining elements from the right side
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        //now we copy the sorted values in temp to arr
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
}
