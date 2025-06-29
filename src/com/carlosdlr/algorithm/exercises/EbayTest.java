package com.carlosdlr.algorithm.exercises;

import java.util.*;

public class EbayTest {

//    Given an array, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]
//    Explanation: 
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//    The distinct triplets are [-1,0,1] and [-1,-1,2].
//

    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        int [] nums1 = {2,0};
        int [] nums2 = {0};
        int [] nums3 = {0,2,3};
        int [] nums4 = null;
        int [] nums5 = {-1,0,-1,2,1,4,-5,-7,5,3-4};

        System.out.println(findTriplets(nums1));
        System.out.println(findTriplets(nums2));
        System.out.println(findTriplets(nums3));
        System.out.println(findTriplets(nums4));
        System.out.println(findTriplets(nums5));

    }

    public static Set<List<Integer>> findTriplets (int [] nums) {
        var result = new HashSet<List<Integer>>();

        if(nums == null) {
            return result;
        }

        if(nums.length < 3) {
            return result;
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        var orderredList = Arrays.asList(nums[i],nums[j], nums[k]);
                        Collections.sort(orderredList);
                        result.add(orderredList);
                    }
                }
            }
        }



        return result;
    }
}
