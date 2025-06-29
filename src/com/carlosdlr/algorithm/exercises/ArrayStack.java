package com.carlosdlr.algorithm.exercises;

public class ArrayStack {
    private final int[] stack;
    private int top;
    private final int capacity;

    // Initialize stack with fixed capacity
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1; // Empty stack marker
    }

    // LIFO OPERATION 1: Push (add to top)
    public void push(int item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. LIFO violation: Cannot add to full stack.");
        }
        stack[++top] = item; // Increment top, then insert
    }

    // LIFO OPERATION 2: Pop (remove from top)
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. LIFO violation: Cannot remove from empty stack.");
        }
        return stack[top--]; // Return top item, then decrement
    }

    // LIFO OPERATION 3: Peek (view top without removal)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. No element to peek.");
        }
        return stack[top];
    }

    // Helper methods
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    // Visualize stack (top -> bottom)
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // Test LIFO behavior
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        stack.push(10); // Bottom
        stack.push(20);
        stack.push(30); // Top
        System.out.println(stack); // [30, 20, 10]

        System.out.println("Pop: " + stack.pop()); // 30 (LIFO: last in, first out)
        System.out.println(stack); // [20, 10]

        stack.push(40);
        System.out.println(stack); // [40, 20, 10]
    }
}