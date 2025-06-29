package com.carlosdlr.algorithm.exercises.searching;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        if(this.root != null) {
            this.root.insert(value);
        } else {
            this.root = new Node(value);
        }
    }

    public void printOrder() {
        if(this.root != null) {
            this.root.printOrder();
        }
    }

    public boolean contains(int value) {
        if (this.root != null) {
            return this.root.contains(value);
        }
        return false;
    }

    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int newValue) {
            // adds the lowest value to the left and the highest to the right balanced binary tree
            if(newValue <= this.value ) {
                if (this.left != null) {
                    this.left.insert(newValue);
                } else {
                    this.left = new Node(newValue);
                }
            } else {
                if (this.right != null) {
                    this.right.insert(newValue);
                } else {
                    this.right = new Node(newValue);
                }
            }
        }

        public void printOrder() {
            if (this.left != null) {
                this.left.printOrder();
            }
            System.out.println(this.value);
            if(this.right != null) {
                this.right.printOrder();
            }
        }

        public boolean contains(int valueToFind) {
            if (valueToFind == this.value){
                return true;
            } else {
                if (valueToFind < this.value) { // search on the left side of the tree
                    if(this.left != null) {
                        return this.left.contains(valueToFind);
                    }
                } else {
                  if(this.right != null) {  // search on the right side of the tree
                      return this.right.contains(valueToFind);
                  }
                }
                return false;
            }
        }
    }

    public static void main(String args []) {
        int [] array = {1,6,2,3,5,1,4,6,2,4,2};
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i <array.length; i++) {
            tree.insert(array[i]);
            System.out.println(tree.contains(array[i]));
        }

        tree.printOrder();

    }
}
