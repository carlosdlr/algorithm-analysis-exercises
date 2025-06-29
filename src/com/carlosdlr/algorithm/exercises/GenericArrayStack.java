package com.carlosdlr.algorithm.exercises;

public class GenericArrayStack<T> {
    private final T[] stack;
    private int top;
    private final int capacity;

    // Initialize stack with fixed capacity
    @SuppressWarnings("unchecked")
    public GenericArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity]; // Generic array creation
        this.top = -1; // Empty stack marker
    }

    // LIFO OPERATION 1: Push (add to top)
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. LIFO violation: Cannot add to full stack.");
        }
        stack[++top] = item; // Increment top, then insert
    }

    // LIFO OPERATION 2: Pop (remove from top)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. LIFO violation: Cannot remove from empty stack.");
        }
        T item = stack[top];
        stack[top--] = null; // Clear reference to avoid memory leak
        return item;
    }

    // LIFO OPERATION 3: Peek (view top without removal)
    public T peek() {
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
    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // Test LIFO behavior with generics
    public static void main(String[] args) {
        // String Stack
        GenericArrayStack<String> stringStack = new GenericArrayStack<>(3);
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        System.out.println(stringStack); // [Third, Second, First]
        System.out.println("Pop: " + stringStack.pop()); // Third (LIFO)
        System.out.println(stringStack); // [Second, First]

        // Integer Stack
        GenericArrayStack<Integer> intStack = new GenericArrayStack<>(2);
        intStack.push(10);
        intStack.push(20);
        System.out.println(intStack.peek()); // 20
    }
}
