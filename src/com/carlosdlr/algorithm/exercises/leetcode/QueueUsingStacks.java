package com.carlosdlr.algorithm.exercises.leetcode;

import java.util.*;

public class QueueUsingStacks {

    private Stack<Integer> stack;

    public QueueUsingStacks() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.stack.add(x);
    }

    public int pop() {
        return this.stack.remove(0);
    }

    public int peek() {
        return this.stack.get(0);
    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks obj = new QueueUsingStacks();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        var builder = new StringBuilder();

        System.out.println(builder.append(param_2).append("---").append(param_3).append("--").append(param_4));
    }
}
