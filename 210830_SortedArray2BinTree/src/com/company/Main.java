package com.company;

import com.company.BTree.BinaryTree;

import java.util.Arrays;

public class Main {
    //        Logical Reasoning:
//        A watch, which loses time uniformly, was observed to be 5 minutes fast at 8.00 p.m. on Thursday.
//        It was noticed to be 7 minutes slow at 8.00 a.m. on the subsequent Monday.
//        When did the watch show the correct time ? Explanation needed.

//        a) 7 a.m. Saturday
//        b) 7 a.m. on Friday
//        c) 10a.m. on Sunday
//        d) 11 a.m. on Friday

//    a)
//  from thurs 8pm to monday 8am is 84 hours
//  find equation for the difference
//  f(x) = kx + 5  where f(0) = 5, f(84) = -7
//  f(84) solve for k
//  f(x) = -1/7 * x + 5
//  find when clock is on time (0)
//  0 = -1/7 * x + 5, solve for x
//  35 = x
//  35hrs from thurs 8pm is sat 7am

    public static void main(String[] args) {
//        For Java and Python;
//        Write a code to Convert sorted array to balanced binary search tree.

        int values[] = {1, 2, 4, 3, 5};
        Arrays.sort(values);
        //System.out.println(Arrays.toString(values));

        BinaryTree btree = BinaryTree.toBalancedBinaryTree(values);
//        BinaryTree btree = new BinaryTree();
//        btree.add(4);
//        btree.add(1);
//        btree.add(2);
//        btree.add(3);
        btree.printLevel();
    }
}
