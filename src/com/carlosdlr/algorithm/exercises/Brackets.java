package com.carlosdlr.algorithm.exercises;

import java.util.Stack;

public class Brackets {

    public static void main(String args[]) {
        System.out.println(isAValidNestedString("{[()()]}"));
    }

    private static int isAValidNestedString(String  nestedString) {
        Stack<Character> charactersStack = new Stack<>();

        for (char c : nestedString.toCharArray()) {
           if(c == '[' || c == '{' || c == '(') {
               charactersStack.push(c);
           } else if (c == '}') {
               if(charactersStack.isEmpty() || charactersStack.pop()!= '{') return 0;
            } else if (c == ']') {
               if(charactersStack.isEmpty() || charactersStack.pop()!= '[') return 0;
           } else if (c == ')') {
               if(charactersStack.isEmpty() || charactersStack.pop()!= '(') return 0;
           }
        }

        return charactersStack.isEmpty() ? 1 : 0;
    }


}

