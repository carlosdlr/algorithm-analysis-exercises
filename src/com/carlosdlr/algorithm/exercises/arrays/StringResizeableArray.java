package com.carlosdlr.algorithm.exercises.arrays;

import java.util.*;

public class StringResizeableArray {
    private String[] items = null;
    private int count = 0;

    public StringResizeableArray(int initialSize) {
        this.items = new String[initialSize];
    }

    public int getSize() {
        return this.count;
    }

    public String get(int index) {
        if(index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    public void set(int index, String item) {
        if(index >= count) {
            throw new IndexOutOfBoundsException();
        }
        items[index] = item;
    }

    public void append(String item) {
        if(count >= items.length) {
            String [] resizedArray = new String[count * 2];
            System.arraycopy(items, 0, resizedArray, 0, count);
            items = resizedArray;
            System.out.println("New size " + items.length);
        }
        items[count] = item;
        count++;
    }

    public static void main(String args[]) {
        StringResizeableArray numbers = new StringResizeableArray(10);
        for(int i =0; i < 100; i++) {
            String s = "Number " + i;
            numbers.append(s);
        }

        for(int i =0; i < 100; i++) {
            System.out.println(numbers.items[i]);
        }

        int[] array = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[2]);
        list.set(1, array[1]);
        list.remove(0);
        System.out.println(list);



    }

}
