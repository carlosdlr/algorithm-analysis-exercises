package com.carlosdlr.algorithm.exercises.leetcode;

import java.util.*;

public class MergeList {


    public static void main(String args[]) {

        var list1 = new ListNode(1, new ListNode(2,new ListNode(4, null)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        var mergeList = new MergeList();
        var result = mergeList.mergeTwoLists(list1, list2);

        var currentNode = result;

        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
