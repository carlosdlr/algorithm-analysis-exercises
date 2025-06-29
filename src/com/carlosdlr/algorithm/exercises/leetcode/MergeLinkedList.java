package com.carlosdlr.algorithm.exercises.leetcode;


import java.util.*;
import java.util.stream.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeLinkedList {

    public static void main(String args[]) {
        // Create two linked lists
        Node<Integer> list1 = new Node<>(1);
        list1.next = new Node<>(2);
        list1.next.next = new Node<>(3);

        Node<Integer> list2 = new Node<>(4);
        list2.next = new Node<>(5);
        list2.next.next = new Node<>(6);

        // Convert linked lists to Java Lists
        List<Node<Integer>> javaList1 = toJavaList(list1);
        List<Node<Integer>> javaList2 = toJavaList(list2);

        // reverse the lists
        Collections.reverse(javaList1);
        Collections.reverse(javaList2);

        // merge the lists
        List<Node<Integer>> mergedList = Stream.concat(javaList1.stream(), javaList2.stream()).collect(Collectors.toList());

        //reverse the merged lists
        Collections.reverse(mergedList);

        // Print the merged list
        mergedList.forEach(node -> System.out.print(node.data + " "));

    }

    private static <T> List<Node<T>> toJavaList(Node<T> head) {
        List<Node<T>> list = new LinkedList<>();
        Node<T> current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list;
    }
}
