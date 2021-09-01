package com;

import com.BTree.BinaryTree;

import java.util.Arrays;

public class Main {
    /***
     * Write a code to Convert sorted array to balanced binary search tree.
     * @param args
     */
    public static void main(String[] args) {
        int values[] = {1, 2, 4, 3, 5};
        Arrays.sort(values);
        BinaryTree btree = BinaryTree.toBalancedBinaryTree(values);
        btree.printLevel();
    }
}